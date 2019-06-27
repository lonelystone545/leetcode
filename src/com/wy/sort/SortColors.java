package com.wy.sort;

/*
 *  Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue. 
	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively. 
	Note:
	You are not suppose to use the library's sort function for this problem. 
 */
public class SortColors {
	
	//设置两个指针，分别指向红和蓝，一个从前往后走，一个从后往前走
	//时间O(n) 空间O(1)
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

	//一个计数的数组，存放每个元素出现的次数，最后遍历即可。（思想：桶排序）
	//时间复杂度O(n) 空间O(1)
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
	//上面的方法可以简写如下
	//时间复杂度O(n) 空间O(1)
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
	
	//快排实现 先按0分割再按1分割
}
