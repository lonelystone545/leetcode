package com.wy.array;

/*
 * Single Number 
 * 
 *  Given an array of integers, every element appears twice except for one. Find that single one.
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	
	
	ʹ�����
	�����ɣ�A XOR B = B XOR A
	�����: A XOR B XOR C = A XOR (B XOR C) = (A XOR B) XOR C
	�Է��ԣ� A XOR B XOR B = A XOR 0 = A
	
	ֻ�ܴ���ż���γ��ֵ����
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
		if(nums==null || nums.length==0) return 0;
        int res = 0;
		for(int i=0;i<nums.length;i++) {
        	res = res^nums[i];
        }
		return res;
    }
}
