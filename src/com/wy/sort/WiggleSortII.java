package com.wy.sort;

import java.util.Arrays;

public class WiggleSortII {
	public void wiggleSort(int[] nums) {
        //�ҵ���λ��
        int median = findKthLargest(nums, (nums.length+1)/2);
        int n = nums.length;
        int left=0,i=0,right=n-1;
        while(i<=right) {
            if(nums[newIndex(i,n)]>median) {
                swap(nums,newIndex(left++,n),newIndex(i++,n));
            } else if(nums[newIndex(i,n)]<median) {
                swap(nums,newIndex(right--,n),newIndex(i,n));
            } else {
                i++;
            }
        }
    }
    //����Ϊn���ҵ�index��Ӧ��λ��
    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

    public int findKthLargest(int[] a,int k) {
        int n = a.length;
        int p = quickselect(a,0,n-1,n-k+1); 
        return a[p];
    }
    //���k��С��Ԫ��
    //���ڿ��������˼�룬��xС�ķ�����ߣ���ķ����ұ�
    private int quickselect(int[] a, int low, int high, int k) {
        int i=low,j=high,x=a[high];
        while(i<j) {
            if(a[i++]>x) {
                swap(a,--i,--j); //����֮����Ҫ��i--��Ҫ�ٴζԽ������Ԫ�ؽ��бȽ�
            }
        }
        //��ʱС��Ԫ���Ѿ������������
        //�������λ�õ�Ԫ�أ������´ε�ѡȡ
        swap(a,i,high);
        //��low->x��Ԫ�ظ���
        int m = i-low+1;
        if(m==k) {
            return i;
        } else if(m>k) { //ѡȡ��xֵ����
            return quickselect(a, low, i-1, k);
        } else { //ѡȡ��xֵ��С
            return quickselect(a, i+1, high, k-m);
        }
    }
    //����Ԫ��
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public void wiggleSort2(int[] nums) {
        Arrays.sort(nums);
        int[] tmp = new int[nums.length];
        int mid = (nums.length-1)/2;
        int index = 0;
        //���鳤��Ϊ����ʱ�����ֻ���һ����
        for(int i=0;i<=mid;i++) {
            tmp[index] = nums[mid-i];
            if(index+1<nums.length) {
                tmp[index+1] = nums[nums.length-1-i];
            }
            index = index+2;
        }
        System.arraycopy(tmp, 0, nums, 0, tmp.length);
    }
}
