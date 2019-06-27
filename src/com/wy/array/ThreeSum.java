package com.wy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 	leetcode15~3Sum
 *  For example, given array S = [-1, 0, 1, 2, -1, -4],

	A solution set is:
	[
  	[-1, 0, 1],
  	[-1, -1, 2]
	]
 */
public class ThreeSum {
	
	/*
	 * 先排序，然后左右夹逼。时间复杂度o(n^2) 
	 * 先固定一个值，然后计算另外两个值相加是否为这个值的相反数即可。
	 * 可以推广到k-sum，只需要k-2次循环，在最内层循环左右夹逼。
	 */
	private List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> threeSum(int[] nums) {
		
		if(nums==null || nums.length<3) return res;
		Arrays.sort(nums);
		//每次固定nums[i] 首尾指针分别i+1和nums.length-1.故i最多只能到i-3
		for(int i=0;i<nums.length-2;i++) {
			if(i>0 && nums[i]==nums[i-1]) continue;//i-1已经比较过了
			helper(nums,i+1,nums.length-1,nums[i]); //首指针从i+1开始，避免结果集的重复
		}
		return res;
	}

	private void helper(int[] nums, int start, int end, int target) {
		int i=start,j=end;
		while(i<j) {
			if(nums[i]+nums[j]+target==0) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(target);
				list.add(nums[i]);
				list.add(nums[j]);
				res.add(list); //放入结果集中
				while(i<j && nums[i]==nums[i+1]) i++;
				while(i<j && nums[j]==nums[j-1]) j--;
				//首尾指针移动
				i++;
				j--;
			} else if(nums[i]+nums[j]+target<0){
				i++;
			} else {
				j--;
			}
		}
	}
}
