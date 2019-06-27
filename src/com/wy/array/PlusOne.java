package com.wy.array;

/*
 *  Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
	You may assume the integer do not contain any leading zero, except the number 0 itself.
	The digits are stored such that the most significant digit is at the head of the list.
	
	���⣺����һ���������һ���������������+1�������������λ������λ��0�ϡ�
 */
public class PlusOne {
	
	public int[] plusOne(int[] digits) {
		for(int i=digits.length-1;i>=0;i--) {
			if(digits[i]<9) {
				digits[i]++;
				return digits;
			} else {
				digits[i]=0;
			}
		}
		//���û�з��أ���˵�����99+1=100
		int[] news = new int[digits.length+1];
		news[0]=1;
		return news;
		
    }
}