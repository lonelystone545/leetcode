package com.wy.sort;

import java.util.Arrays;

public class MaximumGap {
	public int maximumGap(int[] num) { 
		if(num.length<2) return 0;
		int max=Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<num.length;i++) {
			if(num[i]>max) max = num[i];
			if(num[i]<min) min = num[i];
		}
		if(min==max) return 0;  //������ͬ������һ��Ͱ��
		//Ͱ����
		int size = (max-min)/num.length + 1; //����һ��Ͱ
//		int size = (max-min)/num.length ;
		//Ͱ����
		int nums = (max-min)/size + 1;
//		int nums = num.length+1;  //�������������һ��Ͱ�� �϶����п�Ͱ
		//��¼ÿ��Ͱ����Сֵ/���ֵ
		int[] bMin = new int[nums];
		int[] bMax = new int[nums];
		//�������
		Arrays.fill(bMin, Integer.MAX_VALUE);
		Arrays.fill(bMax, Integer.MIN_VALUE);
		
		for(int i=0;i<num.length;i++) {
			//���뼸��Ͱ
			int tmp = (num[i]-min)/size;
			bMin[tmp] = Math.min(num[i], bMin[tmp]);
			bMax[tmp] = Math.max(num[i], bMax[tmp]);
		}
		//Ҫ���������
		int res = Integer.MIN_VALUE;
		int pre = bMax[0];  //��һ��Ͱ�����ֵ
		for(int i=1;i<nums;i++) {
			if(bMin[i]==Integer.MAX_VALUE && bMax[i]==Integer.MIN_VALUE) {
				continue; //��Ͱ����
			}
			res=Math.max(res, bMin[i]-pre); //��ǰͰ����Сֵ
			pre=bMax[i];
		}
//		res=Math.max(res, bMin[nums-1]-pre);//���������һ���ģ�����ͬһ��Ͱ
		return res;
	}
}
