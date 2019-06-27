package com.wy.array;

/*
 *  42. Trapping Rain Water 
 *  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining. 
	For example, 
	Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {
	/*
	 * ����ÿ������height[i]�ܹ����ɵ�ˮ����Ȼ���ۼ�
	 * �ؼ�Ҫ����ÿ�����������Ұ�ĸ߶ȣ������е���Сֵ��Ȼ���ȥͰ�����������
	 * ������������������left��right���ֱ��ʾ����ÿ��������˵�����߶Ⱥ��Ұ�߶�
	 * ʱ��O(n) �ռ�O(n)
	 */
	public int trap2(int[] height) {
		if(height==null || height.length<3) return 0;
		
		int[] lefts = new int[height.length];
		int[] rights = new int[height.length];
		int sum = 0;
		
		//������ɨ�裬����ÿ�����ӣ���������ֵ
		int max=height[0];
		lefts[0] = height[0];
		for(int i=1;i<height.length;i++) {
			lefts[i] = Math.max(max, height[i]);
			max = Math.max(max, height[i]);
		}
		//���ҵ��󣬶���ÿ�����ӣ����ұ����ֵ
		max = height[height.length-1];
		rights[height.length-1] = height[height.length-1];
		for(int i=height.length-2;i>=0;i--) {
			rights[i] = Math.max(max, height[i]);
			max = Math.max(max, height[i]);
		}
		
		//��һ�������һ������װˮ
		for(int i=1;i<height.length-1;i++) {
			int volumn = Math.min(lefts[i], rights[i])-height[i];
			if(volumn>0) {
				sum += volumn;
			}
		}
		return sum;
	}
	
	//����һ�����飬�ҵ���ߵ㣬�������Ϊ���룬�ֱ�����ߺ��ұ�
	//ʱ��O(n) �ռ�O(1)
	public int trap3(int[] height) {
		if(height==null || height.length<3) return 0;
		
		int sum = 0;
		
		//������ӵ��±�
		int max=0;
		for(int i=0;i<height.length;i++) {
			if(height[i]>height[max]) {
				max = i;
			}
		}
		
		for(int i=0,peek=0;i<max;i++) {
			if(height[i]>peek) {
				peek = height[i];
			} else {
				sum += peek-height[i];
			}
		}
		for(int i=height.length-1,top=0;i>max;i--) {
			if(height[i]>top) {
				top = height[i];
			} else {
				sum += top-height[i];
			}
		}
		return sum;
	}
	
	public int trap(int[] A){
	    int a=0;
	    int b=A.length-1;
	    int max=0;
	    int leftmax=0;
	    int rightmax=0;
	    while(a<=b){
	        leftmax=Math.max(leftmax,A[a]);
	        rightmax=Math.max(rightmax,A[b]);
	        if(leftmax<rightmax){
	            max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
	            a++;
	        }
	        else{
	            max+=(rightmax-A[b]);
	            b--;
	        }
	    }
	    return max;
	}
}
