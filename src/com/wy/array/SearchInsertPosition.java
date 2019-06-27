package com.wy.array;

public class SearchInsertPosition {
	//从后向前遍历
	public int searchInsert2(int[] nums, int target) {
        for(int i=nums.length-1;i>=0;i--) {
        	if(nums[i]>target) {
        		continue;
        	} else if(nums[i]<target) {
        		return i+1;
        	} else {
        		return i;
        	}
        }
        return 0;
    }
	//二分查找法
	public int searchInsert(int[] nums, int target) {
		int start=0;
		int end=nums.length-1;
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(nums[mid]==target) {
				return mid;
			} else if(nums[mid]>target) {
				end = mid-1;
			} else {
				start=mid+1;
			}
		}
		return start;
	}
}
