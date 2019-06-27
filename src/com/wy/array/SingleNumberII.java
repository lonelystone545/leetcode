package com.wy.array;

/*
 * Given an array of integers, every element appears three times except for one. Find that single one.
 */
public class SingleNumberII {
	
	int singleNumber(int A[], int n) {
	    int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i < n; i++) {
	        twos |= ones & A[i];
	        ones ^= A[i];// 异或3次 和 异或 1次的结果是一样的
	       //对于ones 和 twos 把出现了3次的位置设置为0 （取反之后1的位置为0）
	        threes = ones & twos;
	        ones &= ~threes;
	        twos &= ~threes;
	    }
	    return ones;
	}
	
	public int singleNumber2(int[] nums) {
		
		//整型占4个字节，将一个整数看成32位表示的二进制数，数组arr记录了对应位上为1的个数
		int[] arr = new int[32];
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<32;j++)
			if((nums[i]>>j & 1)==1) {
				arr[j]++;
			}
		}
		int res=0;
		//数组位置0对应的数的最低位，故每次都要向左移
		for(int i=0;i<arr.length;i++) {
			res += (arr[i]%3 <<i);
		}
		return res;
    }
	//上面是对每一个数计算一个count  这个是按照每一位对所有数计算count
	public int singleNumber(int[] A) {  
        int [] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1)==1) {
                    count[i]++;
                }
            }
            result |= ((count[i] % 3) << i);
        }
        return result;
    }
}
