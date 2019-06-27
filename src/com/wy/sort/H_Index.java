package com.wy.sort;

import java.util.Arrays;
/*
 *  Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index. 
	According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each." 
	For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3. 
	Note: If there are several possible values for h, the maximum one is taken as the h-index. 
 */
public class H_Index {
	//基于计数排序的思想，但是这种比较浪费空间
	//使用计数排序的前提：存在k，使得数组里所有元素的值都不大于N，且元素的值都是非负。
	 public int hIndex2(int[] citations) {
		if(citations.length==0 || citations==null) return 0;
        Arrays.sort(citations);
		int[] arr = new int[citations[citations.length-1]+1];
		for(int i=0;i<citations.length;i++) {
			arr[citations[i]] ++;
		}
		int sum=0;
		for(int i=arr.length-1;i>=0;i--) {
			sum = sum+arr[i];
			if(sum>=i) return i;
		}
		return 0;
	}
	//基于计数排序，对其进行变形
	 public int hIndex(int[] citations) {
		 int[] arr = new int[citations.length+1]; //这里直接按照长度进行分配空间 因为返回的hindex的最大值肯定小于数组的长度
		 for(int i=0;i<citations.length;i++) {
			 if(citations[i]>=citations.length) {
				 arr[citations.length] ++;
			 } else {
				 arr[citations[i]] ++;
			 }
		 }
		 
		int sum=0;
		for(int i=citations.length;i>=0;i--) {
			sum += arr[i];
			if(sum>=i) return i; 
		}
		return 0;
	 }
}
