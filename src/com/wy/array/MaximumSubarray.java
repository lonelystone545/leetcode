package com.wy.array;


/*
 *  leetcode53~Maximum Subarray
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest sum. 
	For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
 * 
 * ���ǵ�ʱ��Ӧ�ôӾֲ���ȫ�֣��ȿ���������ӣ����µ�����һ�����Ѵ����������ͬʱ����maxֵ
 */
public class MaximumSubarray {
	
	//������ÿ����Ҫô���뵽�����Ҫô���Լ���Ϊ��ͷ
	//�������������ں�ǰ������ͣ��������������ͷ
	//����������С�ں�ǰ������ͣ�����������ӵ���������
	public int maxSubArray2(int[] nums) {
        //��¼ÿһ�����ֵ
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
	
	//���Բ�ʹ�������¼ ֱ����һ������
	public int maxSubArray(int[] nums) {
        //��¼ÿһ�����ֵ
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
