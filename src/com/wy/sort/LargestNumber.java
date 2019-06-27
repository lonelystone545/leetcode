package com.wy.sort;

import java.util.Arrays;
import java.util.Comparator;

/*
 *  179~Largest Number
 *  Given a list of non negative integers, arrange them such that they form the largest number.
	For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
	Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for(int i=0;i<nums.length;i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		//利用Comparator接口实现排序
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2+s1).compareTo(s1+s2);//如果s1+s2小,则顺序s2,s1
			}
		});
		
		//字符串拼接
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<strs.length;i++) {
			sb.append(strs[i]);
		}
		
		String result = sb.toString();
		//可能会有0
		int index = 0;
		while(index<result.length() && result.charAt(index)=='0') {
			index++;
		}
		if(index==result.length()) {
			return "0";
		}
		return result.substring(index);
	}
}
