package com.wy.array;

/*
 * 189. Rotate Array 
 * 
 *  Rotate an array of n elements to the right by k steps.
	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
 */
public class RotateArray {
	//申请一个新的数组
	public void rotate2(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
        	arr[(i+k)%nums.length] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, arr.length);
    }
	
	//空间复杂度O(1)
	public void rotate(int[] nums,int k) {
		if(nums==null || nums.length<2) {
			return;
		}
		//保证k在0-nums.length-1
		k = k % nums.length;
		reverse(nums,0,nums.length-1-k);//翻转前部分
		reverse(nums,nums.length-k,nums.length-1);//翻转后部分
		reverse(nums,0,nums.length-1); //翻转整体
	}

	private void reverse(int[] nums, int start, int end) {
		while(start<end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
}
