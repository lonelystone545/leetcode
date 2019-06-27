package com.wy.array;

/*
 *  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	Write a function to determine if a given target is in the array.
	The array may contain duplicates.
 */
public class SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		
		if(nums==null || nums.length==0) return false;
        int start=0,end=nums.length-1;
        while(start<=end) {
        	int mid = start+(end-start)/2;
        	if(nums[mid]==target) return true;
        	if(nums[start]<nums[mid]) { //start-mid期间有序
        		if(nums[start]<=target && target<nums[mid]) {
        			end = mid-1;
        		} else {
        			start = mid+1;
        		} 
        	} else if(nums[start]>nums[mid]) {  //mid-end有序
        		if(nums[mid]<target && target<=nums[end]) {
        			start = mid+1;
        		} else {
        			end = mid-1;
        		}
        	} else {
        		start++;
        	}
        }
        return false;
    }
}
