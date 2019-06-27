package com.wy.sort;

import java.util.Arrays;

/*
 *  摆动排序
 *  给你一个没有排序的数组，请将原数组就地重新排列满足如下性质

	nums[0] <= nums[1] >= nums[2] <= nums[3]....
	请就地排序数组，也就是不需要额外数组
	给出数组为 nums = [3, 5, 2, 1, 6, 4] 一种输出方案为 [1, 6, 2, 5, 3, 4]
 */
public class WiggleSort {
	//先将数组进行排序，然后将第三个和第二个交换，第四个和第五个交换...
	public void wiggleSort2(int[] nums) {
		Arrays.sort(nums);
		for(int i=2;i<nums.length;i+=2) {
			int tmp = nums[i-1];
			nums[i-1] = nums[i];
			nums[i] = tmp;
		}
	}
	
	//交换法
	//奇数时nums[i]>=nums[i-1]  偶数时nums[i]<=nums[i-1] 不符合的需要交换
	public void wiggleSort(int[] nums) {
		for(int i=1;i<nums.length;i++) {
			if((i%2==0 && nums[i]>nums[i-1]) || (i%2==1 && nums[i]<nums[i-1])) {
				int tmp = nums[i-1];
				nums[i-1] = nums[i];
				nums[i] = tmp;
			}
		}
	}
}
