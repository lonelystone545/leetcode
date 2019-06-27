package com.wy.array;

/*
 * 26. Remove Duplicates from Sorted Array
 * 
 *  Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	Do not allocate extra space for another array, you must do this in place with constant memory. 
	For example,
	Given input array nums = [1,1,2], 
	Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length. 
 	Ҫ�ó����ռ䣬�Ͳ���ʹ��set�����ˡ�
 */
public class RemoveDuplicatesfromSortedArray {
	
	//ʱ�临�Ӷ�O(n) ����ָ�룬һ����ǰ�������飬һ����¼���鳤��
	public int removeDuplicates(int[] nums) {
		int len=1;
		for(int index=1;index<nums.length;index++) {
			if(nums[index]!=nums[index-1]) {
				nums[len++] = nums[index]; //�������ȣ���������ֵcopy������len++,i++,����i++
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
	
	//ʱ�临�Ӷ�O(n^2)
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
