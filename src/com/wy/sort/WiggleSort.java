package com.wy.sort;

import java.util.Arrays;

/*
 *  �ڶ�����
 *  ����һ��û����������飬�뽫ԭ����͵���������������������

	nums[0] <= nums[1] >= nums[2] <= nums[3]....
	��͵��������飬Ҳ���ǲ���Ҫ��������
	��������Ϊ nums = [3, 5, 2, 1, 6, 4] һ���������Ϊ [1, 6, 2, 5, 3, 4]
 */
public class WiggleSort {
	//�Ƚ������������Ȼ�󽫵������͵ڶ������������ĸ��͵��������...
	public void wiggleSort2(int[] nums) {
		Arrays.sort(nums);
		for(int i=2;i<nums.length;i+=2) {
			int tmp = nums[i-1];
			nums[i-1] = nums[i];
			nums[i] = tmp;
		}
	}
	
	//������
	//����ʱnums[i]>=nums[i-1]  ż��ʱnums[i]<=nums[i-1] �����ϵ���Ҫ����
	public void wiggleSort(int[] nums) {
		for(int i=1;i<nums.length;i++) {
			if((i%2==0 && nums[i]>nums[i-1]) || (i%2==1 && nums[i]<nums[i-1])) {
				int tmp = nums[i-1];
				nums[i-1] = nums[i];
				nums[i] = tmp;
			}
		}
	}
}
