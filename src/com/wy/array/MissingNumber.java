package com.wy.array;

import java.util.Arrays;
/*
 *  Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array. 
	For example,
	Given nums = [0, 1, 3] return 2. 
	Note:
	Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity? 
 */
public class MissingNumber {
	public int missingNumber2(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		Arrays.sort(nums);
		int number;
		for(number=0;number<nums.length;number++) {
			if(nums[number]!=number) {
				return number;
			}
		}
		//如果是{1,2,3}则返回4
		return number;
    }
	
	//二分法
	public int missingNumber3(int[] nums) { //binary search
	    Arrays.sort(nums);
	    int left = 0, right = nums.length, mid= (left + right)/2;
	    while(left<right){
	        mid = (left + right)/2;
	        if(nums[mid]>mid) right = mid; //说明左边有遗漏的数
	        else left = mid+1;
	    }
	    return left;
	}
	
	//异或  两个相同的数异或为0 则把数组中的每个数和下标全部异或一次，最后的那个数肯定是没出现的数
	public int missingNumber(int[] nums) {
		int res = nums.length;
		for(int i=0;i<nums.length;i++) {
			res ^= i;
			res ^= nums[i];
		}
		return res;
	}
	
	
	
}
