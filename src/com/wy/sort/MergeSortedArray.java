package com.wy.sort;
/*
 * 归并排序 把两个有序的数组num1和nums2合并到1中，假设1中有足够的空间
 * num1和nums2中元素个数分别为m和n
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int k = n+m-1;
		int i = m-1;
		int j = n-1;
		while(i>=0 && j>=0) {
			if(nums1[i]>nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}
		//如果nums2数组还有值(此时i=0)，则直接加到nums1中
		while(j>=0) {
			nums1[k--] = nums2[j--];
		}
		//i!=0时,j=0,由于本来就在nums1中，不需要移动
    }
}
