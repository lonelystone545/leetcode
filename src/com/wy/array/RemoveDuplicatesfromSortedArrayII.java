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
	
	//由于这是已经排序好的数组，只需要加一个变量记录出现的次数即可
	//如果没有排序好，则需要通过hashmap集合记录出现次数
	public int removeDuplicates(int[] nums) {
		if(nums.length<=2) return nums.length;
        int len=1;
        int dupNum = 0; //为0表示不重复，1表示重复了
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
	
	//扩展性比较好 直接把2修改为3就是3次了
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
