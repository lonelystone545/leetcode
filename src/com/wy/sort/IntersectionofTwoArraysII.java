package com.wy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 350. Intersection of Two Arrays II 
	Given two arrays, write a function to compute their intersection. 
	Example:
	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2]. 
	Note:
	Each element in the result should appear as many times as it shows in both arrays.
	The result can be in any order.
 */
public class IntersectionofTwoArraysII {
	//遍历两个数组 逐个比较
	public int[] intersect2(int[] nums1, int[] nums2) {
        int i=0,j=0,k=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        while(i<nums1.length && j<nums2.length) {
        	if(nums1[i]==nums2[j]) {
        		res.add(nums1[i]);
        		i++;
        		j++;
        		k++;
        	} else if(nums1[i]<nums2[j]) {
        		i++;
        	} else {
        		j++;
        	}
        }
        int[] result = new int[res.size()];
        for(int n=0;i<res.size();i++) {
        	result[n] = res.get(n);
        }
        return result;
    }
	
	//使用map集合记录其中一个数组值出现的次数，然后再与另外一个数组进行比较
	public int[] intersect(int[] nums1,int[] nums2) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums1.length;i++) {
			if(map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[i])+1);
			} else {
				map.put(nums1[i], 1);
			}
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<nums2.length;i++) {
			if(map.containsKey(nums2[i]) && map.get(nums2[i])>0) {
				list.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i])-1);
			}
		}
		
		int result[] = new int[list.size()];
        for(int i = 0; i < list.size(); ++i)
            result[i] = list.get(i);
        return result;
	}
}
