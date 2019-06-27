package com.wy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * K-diff Pairs in an Array 
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k. 
 * 
 *  Input: [3, 1, 4, 1, 5], k = 2
	Output: 2
	Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
	Although we have two 1s in the input, we should only return the number of unique pairs.
 * 
 * ע�⣺(a,b)��(b,a)ֻ����һ�����(a,b),�������b>a.Ҳ����˵k��ֵֻ��>=0ʱ������Ч��
 * 		 ��������ע��ȥ��
 */
public class K_diffPairsinanArray {
	
	//hashmap���ϣ����洢Ԫ�أ�ֵ�洢���ֵĴ���
	public int findPairs2(int[] nums, int k) {
		if(nums==null || nums.length ==0 || k<0) return 0;
		Map<Integer,Integer> map = new HashMap<>();
		int count=0;
		for(int n : nums) {
			map.put(n,map.getOrDefault(n, 0)+1);
		}
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(k==0) {
				if(entry.getValue()>=2) {
					count++;
				}
 			} else {
 				if(map.containsKey(entry.getKey()+k)) { //+k����-kֻҪ��һ����ok
 					count++;
 				}
 			}
		}
		return count;
	}
	
	//����ָ���ǰ�����ƶ������в���
	public int findPairs(int[] nums, int k) {
		if(nums==null || nums.length ==0 || k<0) return 0;
		Arrays.sort(nums);
		int count=0;
		int left=0,right=1;
		while(right<nums.length) {
			//�����ǰ��
			if(nums[right]-nums[left]<k) {
				right++;
			} else if(nums[right]-nums[left]>k) {
				left++;
			} else {
				count++;
				left++;
				right++;
				while(left<nums.length && nums[left]==nums[left-1]) {
					left++;
				}
				while(right<nums.length && nums[right]==nums[right-1]) {
					right++;
				}
			}
			if(left==right) right++;
			
		}
		return count;
	}
}
