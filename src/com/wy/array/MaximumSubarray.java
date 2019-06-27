package com.wy.array;


/*
 *  leetcode53~Maximum Subarray
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest sum. 
	For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
 * 
 * 考虑的时候应该从局部到全局，先考虑两两相加，留下的是哪一个，把大的留下来，同时更新max值
 */
public class MaximumSubarray {
	
	//数组中每个数要么加入到别的组要么以自己作为开头
	//如果自身的数大于和前面的数和，则以自身的数开头
	//如果自身的数小于和前面的数和，则将自身的数加到其他的数
	public int maxSubArray2(int[] nums) {
        //记录每一轮最大值
		int[] sum = new int[nums.length];
        int max;
        max = nums[0];
        sum[0] = nums[0];
        
        for(int i=1;i<nums.length;i++){
        	sum[i] = Math.max(nums[i],nums[i]+sum[i-1]);
        	max = Math.max(max, sum[i]);
        }
		return max;
    }
	
	//可以不使用数组记录 直接用一个常量
	public int maxSubArray(int[] nums) {
        //记录每一轮最大值
		int sum;
        int max;
        max = nums[0];
        sum = nums[0];
        
        for(int i=1;i<nums.length;i++){
        	sum = Math.max(nums[i],nums[i]+sum);
        	max = Math.max(max, sum);
        }
		return max;
    }
}
