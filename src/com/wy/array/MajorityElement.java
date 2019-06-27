package com.wy.array;

import java.util.HashMap;
import java.util.Map;

/*
 * 169. Majority Element 
 *  Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
	You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
	//使用集合
	public int majorityElement2(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
        	map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        	if(map.get(nums[i])>len/2) {
        		return nums[i];
        	}
        }
        return 0;
    }
	//时间O(n) 空间O(1)
	//思想：一个变量记录最大出现次数，如果后续的比较不相等，则减少，为0时重新赋值给新值（这种做法主要原因在于假设肯定存在这样的值>n/2)
	public int majorityElement(int[] nums) {
		int count = 0;
		int major = 0;
		for(int i=0;i<nums.length;i++) {
			if(count==0) {
				major = nums[i];
				count++;
			} else if(major==nums[i]){
				count++;
			} else {
				count--;
			}
		}
		return major;
	}
}
