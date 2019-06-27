package com.wy.sort;

/*
 *  Given an unsorted integer array, find the first missing positive integer. 
	For example,
	Given [1,2,0] return 3,
	and [3,4,-1,1] return 2. 
	Your algorithm should run in O(n) time and uses constant space. 
	找到第一个丢失的正整数
	
	普通做法可以先进行排序然后进行判断是否是连续整数，但是时间复杂度不符合要求。本质上是桶排序。
	这里采用比较交换的原则。使数组nums的i位置上存放的元素为i+1，如果不满足则交换，最后进行一次遍历判断即可。
	
	注意：当数据交换之后，还需要对当前交换来的数再次进行比较判断交换操作，否则会直接遗漏，因此使用while循环
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++) {
        	//这里需要使用while循环 因为交换过一次之后，还需要对该位置上的数再次进行判断
        	while(nums[i]>0 && nums[i]<=nums.length && nums[i]!=i+1){
        		int tmp = nums[nums[i]-1];
        		//如果已经相等了，应直接跳出循环，否则会死循环
        		if(tmp==nums[i]) {
        			break;
        		}
        		nums[nums[i]-1] = nums[i];
        		nums[i] = tmp;
        	}
        	
        	
    		
        }
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]!=i+1){
        		return i+1;
        	}
        }
        return nums.length+1;
    }
}
