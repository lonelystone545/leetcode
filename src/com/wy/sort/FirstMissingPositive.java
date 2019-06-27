package com.wy.sort;

/*
 *  Given an unsorted integer array, find the first missing positive integer. 
	For example,
	Given [1,2,0] return 3,
	and [3,4,-1,1] return 2. 
	Your algorithm should run in O(n) time and uses constant space. 
	�ҵ���һ����ʧ��������
	
	��ͨ���������Ƚ�������Ȼ������ж��Ƿ�����������������ʱ�临�ӶȲ�����Ҫ�󡣱�������Ͱ����
	������ñȽϽ�����ԭ��ʹ����nums��iλ���ϴ�ŵ�Ԫ��Ϊi+1������������򽻻���������һ�α����жϼ��ɡ�
	
	ע�⣺�����ݽ���֮�󣬻���Ҫ�Ե�ǰ�����������ٴν��бȽ��жϽ��������������ֱ����©�����ʹ��whileѭ��
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++) {
        	//������Ҫʹ��whileѭ�� ��Ϊ������һ��֮�󣬻���Ҫ�Ը�λ���ϵ����ٴν����ж�
        	while(nums[i]>0 && nums[i]<=nums.length && nums[i]!=i+1){
        		int tmp = nums[nums[i]-1];
        		//����Ѿ�����ˣ�Ӧֱ������ѭ�����������ѭ��
        		if(tmp==nums[i]) {
        			break;
        		}
        		nums[nums[i]-1] = nums[i];
        		nums[i] = tmp;
        	}
        	
        	
    		
        }
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]!=i+1){
        		return i+1;
        	}
        }
        return nums.length+1;
    }
}
