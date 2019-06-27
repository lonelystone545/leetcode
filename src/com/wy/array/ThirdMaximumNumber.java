package com.wy.array;

/*
 * 414. Third Maximum Number 
 *  Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
	Example 1:
	Input: [3, 2, 1]
	
	Output: 1
	
	Explanation: The third maximum is 1.
	
	Example 2:
	Input: [1, 2]
	
	Output: 2
	
	Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
	
	Example 3:
	Input: [2, 2, 3, 1]
	
	Output: 1
	
	Explanation: Note that the third maximum here means the third maximum distinct number.
	Both numbers with value 2 are both considered as second maximum
 */
public class ThirdMaximumNumber {
	 public int thirdMax(int[] nums) {
		 //这里要使用long，因为最后返回的是first还是third是根据这个判断的
		 //也可以维护一个count变量  count++ 如果大于3 就返回third
		 long first=Long.MIN_VALUE,second=Long.MIN_VALUE,third=Long.MIN_VALUE;
		 for(int i=0;i<nums.length;i++) {
			 //去除重复值的影响
			 if(nums[i]==first || nums[i]==second || nums[i]==third) continue;
			 if(nums[i]>first) {
				 third = second;
				 second = first;
				 first = nums[i];
			 } else if(nums[i]>second) {
				 third = second;
				 second = nums[i];
			 } else if(nums[i]>third){
				 third = nums[i];
			 } 
		 }
		 if(third==Long.MIN_VALUE) {
			 return (int)first;
		 } else {
			 return (int)third;
		 }
	 }
	 
	 public int thirdMax2(int[] nums) {
	        Integer max1 = null;
	        Integer max2 = null;
	        Integer max3 = null;
	        for (Integer n : nums) {
	            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
	            if (max1 == null || n > max1) {
	                max3 = max2;
	                max2 = max1;
	                max1 = n;
	            } else if (max2 == null || n > max2) {
	                max3 = max2;
	                max2 = n;
	            } else if (max3 == null || n > max3) {
	                max3 = n;
	            }
	        }
	        return max3 == null ? max1 : max3;
	    }
}
