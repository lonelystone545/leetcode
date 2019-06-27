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
		if(min==max) return 0;  //数字相同，则在一个桶内
		//桶容量
		int size = (max-min)/num.length + 1; //至少一个桶
//		int size = (max-min)/num.length ;
		//桶个数
		int nums = (max-min)/size + 1;
//		int nums = num.length+1;  //最大的数放在最后一个桶中 肯定会有空桶
		//记录每个桶的最小值/最大值
		int[] bMin = new int[nums];
		int[] bMax = new int[nums];
		//填充数组
		Arrays.fill(bMin, Integer.MAX_VALUE);
		Arrays.fill(bMax, Integer.MIN_VALUE);
		
		for(int i=0;i<num.length;i++) {
			//放入几号桶
			int tmp = (num[i]-min)/size;
			bMin[tmp] = Math.min(num[i], bMin[tmp]);
			bMax[tmp] = Math.max(num[i], bMax[tmp]);
		}
		//要求的最大距离
		int res = Integer.MIN_VALUE;
		int pre = bMax[0];  //上一个桶的最大值
		for(int i=1;i<nums;i++) {
			if(bMin[i]==Integer.MAX_VALUE && bMax[i]==Integer.MIN_VALUE) {
				continue; //空桶丢弃
			}
			res=Math.max(res, bMin[i]-pre); //当前桶的最小值
			pre=bMax[i];
		}
//		res=Math.max(res, bMin[nums-1]-pre);//如果数都是一样的，则在同一个桶
		return res;
	}
}
