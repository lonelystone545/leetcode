package com.wy.array;

/*
 * Single Number 
 * 
 *  Given an array of integers, every element appears twice except for one. Find that single one.
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	
	
	使用异或
	交换律：A XOR B = B XOR A
	结合律: A XOR B XOR C = A XOR (B XOR C) = (A XOR B) XOR C
	自反性： A XOR B XOR B = A XOR 0 = A
	
	只能处理偶数次出现的情况
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
