package com.wy.sort;
/*
 * �鲢���� ���������������num1��nums2�ϲ���1�У�����1�����㹻�Ŀռ�
 * num1��nums2��Ԫ�ظ����ֱ�Ϊm��n
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
		//���nums2���黹��ֵ(��ʱi=0)����ֱ�Ӽӵ�nums1��
		while(j>=0) {
			nums1[k--] = nums2[j--];
		}
		//i!=0ʱ,j=0,���ڱ�������nums1�У�����Ҫ�ƶ�
    }
}
