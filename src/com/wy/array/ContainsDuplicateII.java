package com.wy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 219. Contains Duplicate II
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k
 */
public class ContainsDuplicateII {
	//使用hashmap集合 键值分别存储元素值和对应的下标
	 public boolean containsNearbyDuplicate(int[] nums, int k) {
		 
	     Map<Integer,Integer> map = new HashMap<>();
	     for(int i=0;i<nums.length;i++) {
	    	if(map.containsKey(nums[i])) {
	    		int diff = i-map.get(nums[i]);
	    		if(diff<=k) {
	    			return true;
	    		} else {
	    			map.put(nums[i], i); //更新下标
	    		}
	    	} else {
	    		map.put(nums[i], i);
	    	}
	     }
	     return false;
	 }
	 
	 //使用set集合  利用set集合在add时，如果集合中没有包含该元素，则返回true
	 public boolean containsNearbyDuplicate2(int[] nums, int k) {
		 Set<Integer> set = new HashSet<Integer>();
		 for(int i=0;i<nums.length;i++) {
			 if(i>k) { //如果大于k，则移除k之前的元素
				 set.remove(nums[i-k-1]);
			 }
			 if(!set.add(nums[i])) {
				 return true;
			 }
		 }
		 return false;
	 }
}
