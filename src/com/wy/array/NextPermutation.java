package com.wy.array;

import java.util.Arrays;

/*
 * 31. Next Permutation 
 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers. 
	If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order). 
	The replacement must be in-place, do not allocate extra memory. 
	Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	1,2,3 → 1,3,2
	3,2,1 → 1,2,3
	1,1,5 → 1,5,1
 * 
 * 思路： 1 从后往前找，找到第一个不是依次增长的数，记录下位置index
 * 		 2 index为数组的第一个元素的下标时，说明整个数组是降序排列，不存在
 * 				下一个较大的字典值，直接翻转即可
 * 		   index不是第一个元素时，然后再次从后往前找，一直到index+1，找到
 * 			    第一个比nums[index]大的元素，记录下标为biggerIndex，交换index和
 * 			  biggerIndex两个元素值，然后把index后面的元素进行翻转
 */
public class NextPermutation {
	
	public void nextPermutation2(int[] nums) {
        if(nums==null || nums.length<2) return;
       
        int index = -1;
        //从后往前找，找到第一个非递增的的下标
        for(int i=nums.length-2;i>=0;i--) {
        	if(nums[i]<nums[i+1]) {
        		index = i;
        		break;
        	}
        }
        //说明没找到，数组为降序排列，不存在下一个较大的字典值
        if(index==-1) {
        	reverse(nums,0,nums.length-1);
        	return;
        }
        
        //找比nums[index]第一个大的值
        int biggerIndex = index+1;
        for(int i=nums.length-1;i>index;i--) { //从后往前找
        	if(nums[i]>nums[index]) {
        		biggerIndex = i;
        		break;
        	}
        }
        
        //交换index和biggerIndex的值
        swap(nums,index,biggerIndex);
        reverse(nums,index+1,nums.length-1);
        
    }

	//交换数组中两个元素
	private void swap(int[] nums, int index, int biggerIndex) {
		int tmp = nums[index];
		nums[index] = nums[biggerIndex];
		nums[biggerIndex] = tmp;
	}

	//反转start-end部分
	private void reverse(int[] nums, int start, int end) {
		for(int i=start,j=end;i<j;i++,j--) {
			swap(nums,i,j);
		}
	}
	
	
	//简化版本
	public void nextPermutation(int[] nums) {
		if(nums==null || nums.length<2) return;
		int i = nums.length-2;
		while(i>=0 && nums[i]>=nums[i+1]) i--; //从后往前找到第一个非增的值
		if(i>=0) {
			int j=nums.length-1;
			while(nums[j]<=nums[i]) j--;
			swap(nums,i,j);
		}
		reverse(nums,i+1,nums.length-1);
	}
}
