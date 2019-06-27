package com.wy.array;

/*
 *  80~Remove Duplicates from Sorted Array II
 *  Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	For example,
	Given sorted array nums = [1,1,1,2,2,3], 
	Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length. 
 */
public class RemoveDuplicatesfromSortedArrayII {
	
	//���������Ѿ�����õ����飬ֻ��Ҫ��һ��������¼���ֵĴ�������
	//���û������ã�����Ҫͨ��hashmap���ϼ�¼���ִ���
	public int removeDuplicates(int[] nums) {
		if(nums.length<=2) return nums.length;
        int len=1;
        int dupNum = 0; //Ϊ0��ʾ���ظ���1��ʾ�ظ���
        for(int index=1;index<nums.length;index++) {
        	if(nums[index]!=nums[index-1]){
        		nums[len++] = nums[index];
        		if(dupNum!=0) {
        			dupNum = 0;
        		}
        	} else if(dupNum==0) {
        		nums[len++] = nums[index];
        		dupNum++;
        	}
        }
        return len;
    }
	
	//��չ�ԱȽϺ� ֱ�Ӱ�2�޸�Ϊ3����3����
	public int removeDuplicates2(int[] nums) {
		if(nums.length<=2) return nums.length;
		int index=2;
		for(int i=2;i<nums.length;i++) {
			if(nums[i]!=nums[index-2]) {
				nums[index++] = nums[i];
			}
		}
		return index;
	}
}
