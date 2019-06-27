package com.wy.array;

/*
 *  27. Remove Element 
 *  Given an array and a value, remove all instances of that value in place and return the new length. 
	Do not allocate extra space for another array, you must do this in place with constant memory.
	The order of elements can be changed. It doesn't matter what you leave beyond the new length.
	Example:
	Given input array nums = [3,2,2,3], val = 3 
	Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElement {
	
	//两个指针，一个负责遍历，一个负责记录长度并更新数组元素值
	public int removeElement(int[] nums,int val) {
		if(nums==null || nums.length==0) return 0;
		int begin = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=val) {
				nums[begin] = nums[i];
				begin++;
			}
		}
		return begin;
	}
	
	//时间复杂度比较高O(n^2)
	public int removeElement2(int[] nums, int val) {
		int len = nums.length;
		for(int i=0;i<len;i++) {
			if(nums[i]==val) {
				for(int j=i;j<len-1;j++) {
					nums[j]=nums[j+1];
				}
				len--;
				i--;
			}
		}
		return len;
	}
}
