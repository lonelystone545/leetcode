package com.wy.array;

/*
 * 
 * 4. Median of Two Sorted Arrays
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
   Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * 变形：给两个已经排序好的数组，找到两者所有元素中第k大的数
 * 解法1 直接合并两个数组，然后求第k个大的数。时间复杂度O(m+n) (guibing)
 * 解法2 我们需要的是第k个大的数，不需要进行排序。使用一个计数器，记录当前已经找到的第m个大的数。同时使用两个指针pa和
 * 		 pb，分别指向a和b数组的第一个元素，如果数组A当前元素小，那么pa++，同时m++,如果数组B当前元素小，那么pb++,同时，
 * 		 m++。最终当m等于k的时候，就是要求的。O(k)的时间，O(1)的空间。但是当k接近m+n的时候，时间O(m+n)
 * 解法3 我们每次都能删除一个一定在第k个大元素之前的元素，那么我们需要进行k次。如果每次删除一半，类似于二分查找，那就log
 * 		 级的时间了。假设A和B元素个数都大于k/2,则将A的第k/2元素和B的第k/2元素进行比较
 * 		 • A[k/2-1] == B[k/2-1]
		 • A[k/2-1] > B[k/2-1]
		 • A[k/2-1] < B[k/2-1]
		 
		 如果A[k/2-1]<B[k/2-1],意味着A[0]到A[k/2-1]的肯定在AUB的前k个元素范围内，也就是说A[k/2-1]不可能大于合并之后的
		 第k个元素。故可以删除A数组的这k/2个元素。同理，当A[k/2-1]>B[k/2-1]时，可以删除B数组的这k/2元素。
		 当A[k2-1]=B[k/2-1],说明找到了第k个大的元素，直接返回A[k/2-1]或者B[k/2-1]即可。
		 这里用递归实现。终止条件如下：
			1  当A或者B为空时，直接返回B[k-1]或A[k-1]
			2 当k=1时，返回min(A[0],B[0])
			3 当A[k/2-1]==B[k/2-1]时，返回A[k/2-1]或B[k/2-1] 
 */
public class MedianofTwoSorteArrays {
	
	//时间复杂度O(log(m+n))空间O(log(m+n))
	public static double findMedianSortedArrays2(int A[], int B[]) {
	    int m = A.length;
	    int n = B.length;
	    int total = m+n;
	    if (total%2 != 0)
	        return (double) findKth(A, 0, m-1, B, 0, n-1, total/2+1);//k传得是第k个，index实则k-1
	    else {
	        double x = findKth(A, 0, m-1, B, 0, n-1, total/2);//k传得是第k个，index实则k-1
	        double y = findKth(A, 0, m-1, B, 0, n-1, total/2+1);//k传得是第k个，index实则k-1
	        return (double)(x+y)/2;
	    }
	}
	 
	public static int findKth(int[] A, int astart, int aend, int[] B, int bstart, int bend, int k) {
		//数组长度
	    int m = aend - astart + 1;
	    int n = bend - bstart + 1;
	    
	    //假设数组b的长度总是最大
	    if(m>n)
	        return findKth(B,bstart,bend,A,astart,aend,k);
	    //当其中一个数组长度为0时，直接返回另外一个数组的第k个数即可
	    if(m==0)
	        return B[k-1];
	    //如果k为1，返回两个数组中第一个数中的较小的
	    if(k==1)
	        return Math.min(A[astart],B[bstart]);
	    
	    //将k分为两个部分
	    int partA = Math.min(k/2,m);
	    int partB = k - partA;
	    if(A[astart+partA-1] < B[bstart+partB-1]) //直接去除数组A中前partA个数
	        return findKth(A,astart+partA,aend,B,bstart,bend,k-partA);
	    else if(A[astart+partA-1] > B[bstart+partB-1])  //直接去除数组B中前partB个数
	        return findKth(A,astart,aend,B,bstart+partB,bend,k-partB);
	    else
	        return A[astart+partA-1];
	    }
	
	
	public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        return (
            findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)
        ) / 2.0;
    }

    // find kth number of two sorted array
    public static int findKth(int[] A, int A_start,
                              int[] B, int B_start,
                              int k){		
		if (A_start >= A.length) {
			return B[B_start + k - 1];
		}
		if (B_start >= B.length) {
			return A[A_start + k - 1];
		}

		if (k == 1) {
			return Math.min(A[A_start], B[B_start]);
		}
		
		int A_key = A_start + k / 2 - 1 < A.length
		            ? A[A_start + k / 2 - 1]
		            : Integer.MAX_VALUE;
		int B_key = B_start + k / 2 - 1 < B.length
		            ? B[B_start + k / 2 - 1]
		            : Integer.MAX_VALUE; 
		
		if (A_key < B_key) {
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		} else {
			return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		}
    }
}
