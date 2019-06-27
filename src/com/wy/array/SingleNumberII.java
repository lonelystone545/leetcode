package com.wy.array;

/*
 * Given an array of integers, every element appears three times except for one. Find that single one.
 */
public class SingleNumberII {
	
	int singleNumber(int A[], int n) {
	    int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i < n; i++) {
	        twos |= ones & A[i];
	        ones ^= A[i];// ���3�� �� ��� 1�εĽ����һ����
	       //����ones �� twos �ѳ�����3�ε�λ������Ϊ0 ��ȡ��֮��1��λ��Ϊ0��
	        threes = ones & twos;
	        ones &= ~threes;
	        twos &= ~threes;
	    }
	    return ones;
	}
	
	public int singleNumber2(int[] nums) {
		
		//����ռ4���ֽڣ���һ����������32λ��ʾ�Ķ�������������arr��¼�˶�Ӧλ��Ϊ1�ĸ���
		int[] arr = new int[32];
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<32;j++)
			if((nums[i]>>j & 1)==1) {
				arr[j]++;
			}
		}
		int res=0;
		//����λ��0��Ӧ���������λ����ÿ�ζ�Ҫ������
		for(int i=0;i<arr.length;i++) {
			res += (arr[i]%3 <<i);
		}
		return res;
    }
	//�����Ƕ�ÿһ��������һ��count  ����ǰ���ÿһλ������������count
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
