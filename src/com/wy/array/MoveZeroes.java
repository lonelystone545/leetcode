package com.wy.array;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */
public class MoveZeroes {
	
	//一个指针向前遍历  一个指针负责记录非0值
	public void moveZeroes2(int[] nums) {
		int p = 0;
		int len = nums.length;
		for(int i=0;i<len;i++) {
			if(nums[i]!=0) {
				nums[p] = nums[i];
				p++;
			}
		}
		for(int i=p;i<len;i++) {
			nums[i] = 0;
		}
    }
	
	//移动次数最少
	public void moveZeroes(int[] nums) {
		//指针j标记0值的位置
		int j=0;
		for(int i=0;i<nums.length;i++) {
			//非0
			if(nums[i]!=0) {
				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
				j++;
			}
		}
	}
}
