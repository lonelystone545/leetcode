package com.wy.leetcode;

public class BitMap {
	public static void main(String[] args) {
		int[] numbers = {3,5,2,33,6,48,8,14,9};
		//����2�����ȵ�int���飬��Ϊ�����������ֵΪ48
		int[] maps = new int[2];
		for(int i=0;i<numbers.length;i++) {
			setBit(maps,numbers[i]);
		}
		
		for(int i=0;i<maps.length;i++) {
			for(int j=0;j<32;j++) {
				if((maps[i]&(0x01<<j))== (0x01<<j)) {
					System.out.println(i*32+j);
				}
			}
		}
	}
	public static void setBit(int[] maps,int num) {
		//num����Ӧ�������±�
		int index = num>>5;
//		System.out.println(num+":"+index);
		int offset = num&31;
//		System.out.println(num+":"+offset);
		maps[index] = maps[index] | (0x01<<offset);
//		System.out.println(maps[index]);
	}
}
