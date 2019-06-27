package com.wy.array;

/*
 * 26. Remove Duplicates from Sorted Array
 * 
 *  Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	Do not allocate extra space for another array, you must do this in place with constant memory. 
	For example,
	Given input array nums = [1,1,2], 
	Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length. 
 	要用常量空间，就不能使用set集合了。
 */
public class RemoveDuplicatesfromSortedArray {
	
	//时间复杂度O(n) 两个指针，一个向前遍历数组，一个记录数组长度
	public int removeDuplicates(int[] nums) {
		int len=1;
		for(int index=1;index<nums.length;index++) {
			if(nums[index]!=nums[index-1]) {
				nums[len++] = nums[index]; //如果不相等，则把数组的值copy过来且len++,i++,否则i++
			}
		}
		return len;
	}
	
	public int removeDuplicates1(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int index=0;
		for(int i=1;i<nums.length;i++) {
			if(nums[index]!=nums[i]) {
				nums[++index] = nums[i];
			}
		} 
		return index+1;
	}
	
	//时间复杂度O(n^2)
	public int removeDuplicates2(int[] nums) {
	    int len = nums.length;
	    for(int i=0;i<len-1;i++) {
	    	if(nums[i]==nums[i+1]) {
	    		for(int j=i+1;j<len;j++) {
	    			nums[j-1] = nums[j];
	    		}
	    		len--;
	    		i--;
	    	}
	    	
	    }
	    return len;
	}
}
