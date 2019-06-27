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
	 * ������Ȼ�����Ҽбơ�ʱ�临�Ӷ�o(n^2) 
	 * �ȹ̶�һ��ֵ��Ȼ�������������ֵ����Ƿ�Ϊ���ֵ���෴�����ɡ�
	 * �����ƹ㵽k-sum��ֻ��Ҫk-2��ѭ���������ڲ�ѭ�����Ҽбơ�
	 */
	private List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> threeSum(int[] nums) {
		
		if(nums==null || nums.length<3) return res;
		Arrays.sort(nums);
		//ÿ�ι̶�nums[i] ��βָ��ֱ�i+1��nums.length-1.��i���ֻ�ܵ�i-3
		for(int i=0;i<nums.length-2;i++) {
			if(i>0 && nums[i]==nums[i-1]) continue;//i-1�Ѿ��ȽϹ���
			helper(nums,i+1,nums.length-1,nums[i]); //��ָ���i+1��ʼ�������������ظ�
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
				res.add(list); //����������
				while(i<j && nums[i]==nums[i+1]) i++;
				while(i<j && nums[j]==nums[j-1]) j--;
				//��βָ���ƶ�
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
