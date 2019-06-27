package com.wy.array;

/*
 *  33. Search in Rotated Sorted Array
 *  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	You are given a target value to search. If found in the array return its index, otherwise return -1.
	You may assume no duplicate exists in the array.
 */
public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		
		if(nums.length==0 || nums==null) return -1;
		
        int start=0,end=nums.length-1;
        while(start<=end) {
        	int mid = start+(end-start)/2;
        	if(nums[mid]==target) return mid;
        	//这里必须是<= 案例{3,1} 1
        	if(nums[start]<=nums[mid]) { //start-mid有序
        		if(nums[start]<=target && target<nums[mid]) { //左边查找
        			end = mid-1;
        		} else {
        			start = mid+1;
        		}
        	} else {  //mid-end有序
        		if(nums[mid]<target && target<=nums[end]) {  //右边查找
        			start = mid+1;
        		} else {
        			end = mid-1;
        		}
        	}
        }
        return -1;
    }
}
