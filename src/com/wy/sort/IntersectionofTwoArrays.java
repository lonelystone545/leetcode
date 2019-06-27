package com.wy.sort;

import java.util.Arrays;
import java.util.HashSet;

/*
 *  349. Intersection of Two Arrays 
 *  Given two arrays, write a function to compute their intersection. 
	Example:
	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2]. 
	Note:
	Each element in the result must be unique.
	The result can be in any order.
 */
public class IntersectionofTwoArrays {
	
	//两个指针 遍历数组 由于不能出现重复的值，因此多了一层判断
	public int[] intersection2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
	    Arrays.sort(nums2);
	        
        int i = 0, j = 0;
        int[] temp = new int[nums1.length];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || temp[index - 1] != nums1[i]) {
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
	        
        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = temp[k];
        }
        
        return result;
	}
	
	//使用set集合存储数组元素值
	public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hash.add(nums1[i]);
        }
        
        HashSet<Integer> resultHash = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hash.contains(nums2[i]) && !resultHash.contains(nums2[i])) {
                resultHash.add(nums2[i]);
            }
        }
        
        int size = resultHash.size();
        int[] result = new int[size];
        int index = 0;
        for (Integer num : resultHash) {
            result[index++] = num;
        }
        
        return result;
    }
}
