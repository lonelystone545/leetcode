package com.wy.array;

import java.util.ArrayList;
import java.util.List;

/*
 * 448. Find All Numbers Disappeared in an Array
 * Given an array of integers where 1 �� a[i] �� n (n = size of array), some elements appear twice and others appear once.
	Find all the elements of [1, n] inclusive that do not appear in this array.
	Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space
	
	Input:
	[4,3,2,7,8,2,3,1]
	
	Output:
	[5,6]
	
	
	˼·�����Ǳ���Ѿ��������ֵ�����Ȼ�󷴹���ȥ��û�г��ֵ���
 */
public class FindAllNumbersDisappearedinanArray {
	 //��ʱ
	 public static List<Integer> findDisappearedNumbers2(int[] nums) {
		 List<Integer> res = new ArrayList<>();
		 int len = nums.length;
		 for(int i=1;i<=len;i++) {
			 res.add(i);
		 }
		 for(int n : nums) {
			 if(res.contains(n)) {
				 res.remove(Integer.valueOf(n));
			 }
		 }
		 return res;
	 }
	 
	 public  List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++) {
        	//������ظ���������ֻ����һ������Ϊ�෴��
        	//�����ŵ���Ӧ������λ���� ��λ��i�Ϸ�i+1
        	int val = Math.abs(nums[i])-1;
        	if(nums[val]>0) {
        		//���Ϊ����
        		nums[val] = -nums[val];
        	}
        }
        
        //������һ���ı�ǣ��������ֵ������为��
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]>0) {
        		res.add(i+1);
        	}
        }
        return res;
    }
	
	 public  List<Integer> findDisappearedNumbers(int[] nums) {
		 List<Integer> res = new ArrayList<Integer>();
		 int len = nums.length;
		 for(int i=0;i<len;i++) {
			 nums[(nums[i]-1)%len] += len;
		 }
		 for(int i=0;i<len;i++) {
			 if(nums[i]<=len) {
				 res.add(i+1);
			 }
		 }
		 return res;
	 }
	
}
