package com.wy.array;


/*
 * 
 * 
 *  135. Candy 
 * 
 *  There are N children standing in a line. Each child is assigned a rating value. 
	You are giving candies to these children subjected to the following requirements: 
	Each child must have at least one candy.
	Children with a higher rating get more candies than their neighbors.
	What is the minimum candies you must give? 
 * 
 * ����������trapping water��Ŀ����������ˮ���Ƿ��ǣ�Ӱ�����ض���ֻ��һ�ߣ��������������ߵ����ֵ��Сֵ�����ġ�
 * 1 �������i+1��rate���ں���i��rate����ô����i+1���ǹ�=����i���ǹ�+1���������С�ڻ��ߵ��ڣ�������ȷ����
 * 	  ����i+1���ٿ��ǡ���ʱ�����Ȳ�����Ȼ�������������һ�Σ�������Щ���ӡ����ȡ�����ߵ����ֵ�ۼӼ��ɡ�
 * 	  �ռ临�Ӷ�O(n)
 * 
 * 2 ������������þ��ǽ��б���ʱ��¼���ֵ����Сֵ����������Ƿǵݼ����У��Ͳ���Ҫ�����ռ��ˣ���Ϊÿ�����Ӹ����ǹ�������ȷ������
 * 	  ��������ǵݼ����У��Ͳ���Ψһ��ȷ���ˣ��� 1 5 4 3 ����һ�����Ӹ��ǹ���1���ǵڶ������Ӹ����ǹ����Ƕ����أ��Ǹ��ݵݼ����еĳ��Ⱦ����ġ�
 * 	 5 4 3�ݼ����г�����3���ǵڶ�������Ӧ�ø�3���ǹ�������������Ӧ�ø�2���ǹ������ĸ�����Ӧ�ø�4���ǹ���
 *   �ǿ����ȶ��䲻���д����ݼ����еĵ�һ���Ѿ������ǹ����Ȳ��ܣ�4 3 ������Ϊcount��2�������ǹ�����Ϊ1+2=3��5��Ӧ�ĺ������ڵ��ǹ�����pre:2��
 *   ��count>=2��5��Ӧ��������ӵ��ǹ�Ӧ�����·��䣬�������ϼ�(count-pre)+1
 * 	 
 */
public class Candy {
	
	//O(1)�Ŀռ临�Ӷ�
	public int candy2(int[] ratings) {
		if(ratings==null || ratings.length==0) {
			return 0;
		}
		//ǰһ�����Ӹ����ǹ���
		int pre = 1;
		//�ݼ����еĳ��ȣ��������ݼ����еĵ�һ������
		int count = 0;
		//����sum
		int sum = 1;
		//�ӵڶ������ӿ�ʼ����
		for(int i=1;i<ratings.length;i++) {
			if(ratings[i]>=ratings[i-1]) {
				if(count>0) {
					sum += (1+count)*count/2;
					if(count>=pre) { //�Եݼ����еĵ�һ����������������
						sum += count-pre+1;
					}
					//����
					count = 0;
					pre=1; 
				}
				pre = (ratings[i]==ratings[i-1]? 1:pre+1);
				sum += pre;
			} else {
				count++;
			}
		}
		//����ݼ�����һֱ������
		if(count>0) {
			sum += (1+count)*count/2;
			if(count>=pre) {
				sum += count-pre+1;
			}
		}
		return sum;
	}
	
	//��������  ��һ������Ҳ��ok�ģ��������ʱ�������ߵ�rate���ұ߸ߣ�Ӧ��ȷ������ǹ����ࡣ
	public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) {
        	return 0;
        }
        int[] lefts = new int[ratings.length];
        int[] rights = new int[ratings.length];
        //�������ұ���
        lefts[0]=1;
        for(int i=1;i<ratings.length;i++) {
        	if(ratings[i]>ratings[i-1]) {
        		lefts[i] = lefts[i-1]+1;
        	} else { 
        		lefts[i] = 1;
        	}
        }
        //�����������
        rights[ratings.length-1] = 1;
        for(int i=ratings.length-2;i>=0;i--) {
        	if(ratings[i]>ratings[i+1]) {
        		rights[i] = rights[i+1]+1;
        	} else {
        		rights[i] = 1;
        	}
        }
        
        int sum = 0;
        for(int i=0;i<ratings.length;i++) {
        	sum += Math.max(lefts[i], rights[i]);
        }
        return sum;
    }
}
