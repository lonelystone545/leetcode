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
		//�����{1,2,3}�򷵻�4
		return number;
    }
	
	//���ַ�
	public int missingNumber3(int[] nums) { //binary search
	    Arrays.sort(nums);
	    int left = 0, right = nums.length, mid= (left + right)/2;
	    while(left<right){
	        mid = (left + right)/2;
	        if(nums[mid]>mid) right = mid; //˵���������©����
	        else left = mid+1;
	    }
	    return left;
	}
	
	//���  ������ͬ�������Ϊ0 ��������е�ÿ�������±�ȫ�����һ�Σ������Ǹ����϶���û���ֵ���
	public int missingNumber(int[] nums) {
		int res = nums.length;
		for(int i=0;i<nums.length;i++) {
			res ^= i;
			res ^= nums[i];
		}
		return res;
	}
	
	
	
}
