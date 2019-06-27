package com.wy.sort;

/*
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm
 */
public class H_IndexII {
	
	//在上题的基础上，升序排列
	public int hIndex2(int[] citations) {
		int length = citations.length;
		if(length==0) return 0;
		//计数  从最大->小开始计数
		int count = 0;
		for(int i=length-1;i>=0;i--) {
			if(count>=citations[i]) { //此时小于citations[i]的数最多只有citations[i]-1个
				return count;
			}
			count++;
		}
		return count; //说明数组的数都大于count(0个数小于count，count数大于count）
	}
	
	//利用二分法查找
	public int hIndex(int[] citations) {
		int length = citations.length;
		int left = 0,right=length-1,mid=0;
		while(left<=right) {
			mid=(left+right)>>1;
			if(citations[mid]==(length-mid)) { //citations[mid] papers至少有citations[mid] citations
				return citations[mid];
			} else if(citations[mid]>(length-mid)) { //没有那么多的citations[mid] papers，应该在左侧继续查找
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		return length-(right+1);
	}
}
