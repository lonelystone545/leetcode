package com.wy.sort;

import java.util.Arrays;

public class WiggleSortII {
	public void wiggleSort(int[] nums) {
        //找到中位数
        int median = findKthLargest(nums, (nums.length+1)/2);
        int n = nums.length;
        int left=0,i=0,right=n-1;
        while(i<=right) {
            if(nums[newIndex(i,n)]>median) {
                swap(nums,newIndex(left++,n),newIndex(i++,n));
            } else if(nums[newIndex(i,n)]<median) {
                swap(nums,newIndex(right--,n),newIndex(i,n));
            } else {
                i++;
            }
        }
    }
    //长度为n，找到index对应的位置
    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

    public int findKthLargest(int[] a,int k) {
        int n = a.length;
        int p = quickselect(a,0,n-1,n-k+1); 
        return a[p];
    }
    //求第k个小的元素
    //基于快速排序的思想，比x小的放在左边，大的放在右边
    private int quickselect(int[] a, int low, int high, int k) {
        int i=low,j=high,x=a[high];
        while(i<j) {
            if(a[i++]>x) {
                swap(a,--i,--j); //交换之后，需要对i--，要再次对交换后的元素进行比较
            }
        }
        //此时小的元素已经被交换到左边
        //交换最高位置的元素，便于下次的选取
        swap(a,i,high);
        //从low->x的元素个数
        int m = i-low+1;
        if(m==k) {
            return i;
        } else if(m>k) { //选取的x值过大
            return quickselect(a, low, i-1, k);
        } else { //选取的x值过小
            return quickselect(a, i+1, high, k-m);
        }
    }
    //交换元素
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public void wiggleSort2(int[] nums) {
        Arrays.sort(nums);
        int[] tmp = new int[nums.length];
        int mid = (nums.length-1)/2;
        int index = 0;
        //数组长度为奇数时，最后只添加一个数
        for(int i=0;i<=mid;i++) {
            tmp[index] = nums[mid-i];
            if(index+1<nums.length) {
                tmp[index+1] = nums[nums.length-1-i];
            }
            index = index+2;
        }
        System.arraycopy(tmp, 0, nums, 0, tmp.length);
    }
}
