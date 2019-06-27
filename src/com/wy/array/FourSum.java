package com.wy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * http://www.sigmainfy.com/blog/summary-of-ksum-problems.html
 * 18. 4Sum
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

	A solution set is:
	[
  		[-1,  0, 0, 1],
  		[-2, -1, 1, 2],
  		[-2,  0, 0, 2]
	]
	
	可以使用hashmap缓存两个数的和sum，键存储sum，值存储的是一个List<Integer[]>,数组里是对应的两个数
 */
public class FourSum {
	
	//时间复杂度O(n^3)
	public List<List<Integer>> fourSum2(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length<4) return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++) {
        	if(i>0 && nums[i]==nums[i-1]) continue;
        	for(int j=i+1;j<nums.length-2;j++) {
        		if(j>i+1 && nums[j]==nums[j-1]) continue;
        		int top = j+1,tail= nums.length-1;
        		while(top<tail) {
        			if(nums[i]+nums[j]+nums[top]+nums[tail]==target) {
        				List<Integer> list = new ArrayList<Integer>();
        				list.add(nums[i]);
        				list.add(nums[j]);
        				list.add(nums[top]);
        				list.add(nums[tail]);
        				res.add(list);
        				while(top<tail && nums[top]==nums[top+1]) top++;
        				while(top<tail && nums[tail]==nums[tail-1]) tail--;
        				top++;
        				tail--;
        			} else if(nums[i]+nums[j]+nums[top]+nums[tail]<target) {
        				top++;
        			} else {
        				tail--;
        			}
        		}
        	}
        }
        return res;
    }
	
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (nums == null || len < 4)
			return res;

		Arrays.sort(nums);

		int max = nums[len - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return res;

		int i, z;
		for (i = 0; i < len; i++) {
			z = nums[i];
			if (i > 0 && z == nums[i - 1])// avoid duplicate
				continue;
			if (z + 3 * max < target) // z is too small
				continue;
			if (4 * z > target) // z is too large
				break;
			if (4 * z == target) { // z is the boundary
				if (i + 3 < len && nums[i + 3] == z)
					res.add(Arrays.asList(z, z, z, z));
				break;
			}

			threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
		}

		return res;
	}

	/*
	 * Find all possible distinguished three numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, the three numbers))
	 */
	public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1) {
		if (low + 1 >= high)
			return;

		int max = nums[high];
		if (3 * nums[low] > target || 3 * max < target)
			return;

		int i, z;
		for (i = low; i < high - 1; i++) {
			z = nums[i];
			if (i > low && z == nums[i - 1]) // avoid duplicate
				continue;
			if (z + 2 * max < target) // z is too small
				continue;

			if (3 * z > target) // z is too large
				break;

			if (3 * z == target) { // z is the boundary
				if (i + 1 < high && nums[i + 2] == z)
					fourSumList.add(Arrays.asList(z1, z, z, z));
				break;
			}

			twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
		}

	}

	/*
	 * Find all possible distinguished two numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
	 */
	public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1, int z2) {

		if (low >= high)
			return;

		if (2 * nums[low] > target || 2 * nums[high] < target)
			return;

		int i = low, j = high, sum, x;
		while (i < j) {
			sum = nums[i] + nums[j];
			if (sum == target) {
				fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

				x = nums[i];
				while (++i < j && x == nums[i]) // avoid duplicate
					;
				x = nums[j];
				while (i < --j && x == nums[j]) // avoid duplicate
					;
			}
			if (sum < target)
				i++;
			if (sum > target)
				j--;
		}
		return;
	}
}
