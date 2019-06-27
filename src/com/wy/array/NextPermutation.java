package com.wy.array;

import java.util.Arrays;

/*
 * 31. Next Permutation 
 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers. 
	If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order). 
	The replacement must be in-place, do not allocate extra memory. 
	Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	1,2,3 �� 1,3,2
	3,2,1 �� 1,2,3
	1,1,5 �� 1,5,1
 * 
 * ˼·�� 1 �Ӻ���ǰ�ң��ҵ���һ����������������������¼��λ��index
 * 		 2 indexΪ����ĵ�һ��Ԫ�ص��±�ʱ��˵�����������ǽ������У�������
 * 				��һ���ϴ���ֵ�ֵ��ֱ�ӷ�ת����
 * 		   index���ǵ�һ��Ԫ��ʱ��Ȼ���ٴδӺ���ǰ�ң�һֱ��index+1���ҵ�
 * 			    ��һ����nums[index]���Ԫ�أ���¼�±�ΪbiggerIndex������index��
 * 			  biggerIndex����Ԫ��ֵ��Ȼ���index�����Ԫ�ؽ��з�ת
 */
public class NextPermutation {
	
	public void nextPermutation2(int[] nums) {
        if(nums==null || nums.length<2) return;
       
        int index = -1;
        //�Ӻ���ǰ�ң��ҵ���һ���ǵ����ĵ��±�
        for(int i=nums.length-2;i>=0;i--) {
        	if(nums[i]<nums[i+1]) {
        		index = i;
        		break;
        	}
        }
        //˵��û�ҵ�������Ϊ�������У���������һ���ϴ���ֵ�ֵ
        if(index==-1) {
        	reverse(nums,0,nums.length-1);
        	return;
        }
        
        //�ұ�nums[index]��һ�����ֵ
        int biggerIndex = index+1;
        for(int i=nums.length-1;i>index;i--) { //�Ӻ���ǰ��
        	if(nums[i]>nums[index]) {
        		biggerIndex = i;
        		break;
        	}
        }
        
        //����index��biggerIndex��ֵ
        swap(nums,index,biggerIndex);
        reverse(nums,index+1,nums.length-1);
        
    }

	//��������������Ԫ��
	private void swap(int[] nums, int index, int biggerIndex) {
		int tmp = nums[index];
		nums[index] = nums[biggerIndex];
		nums[biggerIndex] = tmp;
	}

	//��תstart-end����
	private void reverse(int[] nums, int start, int end) {
		for(int i=start,j=end;i<j;i++,j--) {
			swap(nums,i,j);
		}
	}
	
	
	//�򻯰汾
	public void nextPermutation(int[] nums) {
		if(nums==null || nums.length<2) return;
		int i = nums.length-2;
		while(i>=0 && nums[i]>=nums[i+1]) i--; //�Ӻ���ǰ�ҵ���һ��������ֵ
		if(i>=0) {
			int j=nums.length-1;
			while(nums[j]<=nums[i]) j--;
			swap(nums,i,j);
		}
		reverse(nums,i+1,nums.length-1);
	}
}
