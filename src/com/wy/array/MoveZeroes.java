package com.wy.array;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */
public class MoveZeroes {
	
	//һ��ָ����ǰ����  һ��ָ�븺���¼��0ֵ
	public void moveZeroes2(int[] nums) {
		int p = 0;
		int len = nums.length;
		for(int i=0;i<len;i++) {
			if(nums[i]!=0) {
				nums[p] = nums[i];
				p++;
			}
		}
		for(int i=p;i<len;i++) {
			nums[i] = 0;
		}
    }
	
	//�ƶ���������
	public void moveZeroes(int[] nums) {
		//ָ��j���0ֵ��λ��
		int j=0;
		for(int i=0;i<nums.length;i++) {
			//��0
			if(nums[i]!=0) {
				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
				j++;
			}
		}
	}
}
