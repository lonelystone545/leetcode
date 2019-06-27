package com.wy.sort;

/*
 *  Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue. 
	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively. 
	Note:
	You are not suppose to use the library's sort function for this problem. 
 */
public class SortColors {
	
	//��������ָ�룬�ֱ�ָ��������һ����ǰ�����ߣ�һ���Ӻ���ǰ��
	//ʱ��O(n) �ռ�O(1)
	public void sortColors(int[] nums) {
		int redindex = 0;
		int blueindex = nums.length-1;
		for(int i=0;i<blueindex+1;) {
			if(nums[i]==0) {
				swap(nums,i++,redindex++);
			} else if(nums[i]==2) {
				swap(nums,i,blueindex--);
			} else {
				i++;
			}
		}
		
		
	}
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	//һ�����������飬���ÿ��Ԫ�س��ֵĴ��������������ɡ���˼�룺Ͱ����
	//ʱ�临�Ӷ�O(n) �ռ�O(1)
	public void sortColors2(int[] nums) {
        int[] counts = new int[3];
        for(int i=0;i<nums.length;i++) {
        	if(counts[i]==0) {
        		counts[0]++;
        	} else if(counts[i]==1) {
        		counts[1]++;
        	} else {
        		counts[2]++;
        	}
        }
        
        int j=0;
        for(int i=0;i<counts.length;i++) {
        	while(counts[i]!=0) {
        		nums[j++]=i;
        		counts[i]--;
        	}
        }
    }
	//����ķ������Լ�д����
	//ʱ�临�Ӷ�O(n) �ռ�O(1)
	public void sortColors3(int[] nums) {
        int[] counts = new int[3];
        for(int i=0;i<nums.length;i++) {
        	counts[nums[i]]++;
        }
        
        for(int i=0,index=0;i<counts.length;i++) {
        	for(int j=0;j<counts[i];j++) {
        		nums[index++] = i;
        	}
        }
    }
	
	//����ʵ�� �Ȱ�0�ָ��ٰ�1�ָ�
}
