package com.wy.array;

import java.util.Arrays;

/*
 *  16. 3Sum Closest 
 *  Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
	For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
	//时间复杂度O(n^2)
	public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length<3) return 0;
        //先排序
        Arrays.sort(nums);
        
        int closest = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0;i<nums.length-2;i++) {
        	if(i>1 && nums[i]==nums[i-1]) continue;
        	//固定nums[i]
        	int top = i+1,tail=nums.length-1;
        	while(top<tail) {
        		int sum = nums[i]+nums[top]+nums[tail];
        		if(sum<target) {
        			if(target-sum<closest) {
        				//更新最小的差值
        				closest = target-sum;
        				res = sum;
        			}
        			top++;
        		} else if(sum>target) {
        			if(sum-target<closest) {
        				closest = sum-target;
        				res = sum;
        			}
        			tail--;
        		} else { //相等，则直接返回
        			return sum;
        		}
        	}
        }
        return res;
    }
}
