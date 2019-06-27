package com.wy.array;

/*
 * 134. Gas Station 
 *  There are N gas stations along a circular route, where the amount of gas at station i is gas[i]. 
	You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations. 
	Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
	
	˼·��
		 ����һ��ÿ��վ�㶼��Ϊ��ʼ�㣬��ʼ�������ж��Ͳ��Ƿ�С��0�����С�ڣ�������һ��վ��Ϊ��ʼ�����ִ���������̣������С�ڣ������
		  ֮ǰ��ʣ����������ǰ�ߣ�ֱ��С��0���߱��������������ⷨʱ�临�Ӷ���O(n^2)����leetcode�лᳬʱ��
		  
		 ��������ֻ��Ҫһ�α�����ʱ�临�Ӷ�O(n).
		 		�ӵ�0��վ�㿪ʼ�����赽pվ��ʱ���Ͳ�<0   sum1 = diff[0] +diff[1] + �� + diff[p]<0
		 		����ֻ��Ҫѡ��p+1վ����Ϊ��ʼ�㼴�ɣ�����Ҫ�ӵ�1��վ�㳢�ԣ���Ϊ�������ܻ�û��p��sum��С��0�ˣ��ټ���վ��0���͡�
		 		�ڱ���������ʱ�򣬻��б�Ҫ��Ȧ�������ٴ���֤ô�����ǲ���Ҫ�ġ�ֻ��Ҫ��¼һ�����������洢���е��Ͳ���С��0��
		 		�򲻴�������վ�㣬�����С��0����϶����㡣
		 		
		 		
	�����վ�� i ����������վ�� k ֮ǰ����Ȼ�ܱ�֤��������û���׶�����k �����󣬼��׶��ˡ���ô��˵�� diff[i] + diff[i+1] + �� + diff[k] < 0��������diff[k]���⣬��diff[i]��ʼ���ۼӶ��� >= 0�ġ�Ҳ����˵diff[i] Ҳ�� >= 0�ģ����ʱ�����ǻ��б�Ҫ��վ�� i + 1��������ϸһ���֪������Ҫ�Ǵ�վ�� i+1����������վ��k��������û��վ��k������ͼ��׶��ˣ���Ϊ�ټ���վ�� i ���͡����� 
������ˣ������Ƿ��ֵ���k վ��������׶���i �� k ��Щվ�㶼������Ϊ�������������ˣ��϶�������������ֻ��Ҫ��k+1վ�㳢�Լ��ɣ���˽ⷨʱ�临�Ӷȴ�O(n2)������ O(2n)��֮������O(2n)������Ϊ��k+1վ��Ϊʼ��վ��������Ȧ����k������֤k+1�Ƿ����㡣 
�����ȵȣ������Ҫ������ 
��������ģ��һ�¹��̣� 
����a. �ʼ��վ��0��ʼ��վ�����賵����վ��p��������ˣ�����sum1 = diff[0] +diff[1] + �� + diff[p]����֪sum1 < 0�� 
����b. ������������������ǽ�p+1��Ϊʼ��վ������qվ�������ֿ��ˣ� ��sum2 = diff[p+1] +diff[p+2] + �� + diff[q]����֪sum2 < 0�� 
����c. ��q+1��Ϊʼ��վ������һֱ������δѭ������ĩվ������û���׶�����sum3 = diff[q+1] +diff[q+2] + �� + diff[size-1]����֪sum3 >= 0�� 
����Ҫ��֪�����ܷ񿪻� q վ����ʵ������sum3 �Ļ����ϣ����μ��� diff[0] �� diff[q]������sum3������������Ƿ��С��0����������֮ǰ�Ѿ�֪�� diff[0] �� diff[p-1] ���·��������һֱ���ַǸ����������ֻҪ����sum3 + sum1�Ƿ� <0����֪���ܲ��ܿ��� p+1վ�ˡ� 
��������ܴ�p+1վ������ֻҪ����sum3 + sum1 + sum2 �Ƿ� < 0����֪���ܲ��ܿ���qվ�ˡ� 
������Ϊ sum1, sum2 �� < 0�������� sum3 + sum1 + sum2 >=0 ��ôsum3 + sum1 ��Ȼ >= 0��Ҳ����˵��ֻҪsum3 + sum1 + sum2 >=0������Ȼ�ܿ���qվ����sum3 + sum1 + sum2 ��ʵ���� diff������ܺ� Total������������Ԫ���Ѿ�������ˡ� 
������� Total �ܷ� >= 0�������Ƿ����������վ��� ��ֱ�Ҫ������ 
��������ʱ�临�ӶȽ�һ����O(2n)������ O(n)��
 */
public class GasStation {
	
	//ʱ�临�Ӷ�O(n)
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas==null || cost==null || gas.length==0 || cost.length==0) return -1;
		
		//��¼�ܹ��Ĳ�ֵ
		int total = 0;
		//��i��վ����� ��ֵ
		int sum = 0;
		//��¼��һ��վ���λ��
		int index = -1;
		for(int i=0;i<gas.length;i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			
			if(sum<0) {
				index = i;
				sum = 0;
			}
		}
		if(total<0) {
			return -1;
		} else {
			return index+1;
		}
	}
	
	
	public int canCompleteCircuit3(int[] gas, int[] cost) {  
        //���δ�ÿһ������վ����  
        for (int i = 0; i < gas.length; i++) {  
            int j = i;  
            int curgas = gas[j];  
              
            while (curgas >= cost[j]) { //�����ǰ���������ܹ�������һվ  
                curgas -= cost[j];      //��ȥ���ε�����  
                  
                j = (j + 1) % gas.length; //������һվ  
                if (j == i) return i;   //����ص�����ʼվ����ô���гɹ�  
                  
                curgas += gas[j];       //����һվ�����¼��ͣ�����ǰ��  
            }  
        }  
        return -1;  
    }  
	
	//ʱ�临�Ӷ�O(n^2) �ᳬʱ
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		
		if(gas.length==1 || cost.length==1) return 0;
		
        int[] dif = new int[gas.length];
        for(int i=0;i<gas.length;i++) {
        	dif[i] = gas[i]-cost[i];
        }
        int sum=0;
        for(int i=0;i<dif.length;i++) {
        	sum += dif[i];
        }
        if(sum<0) return -1;
        sum = 0;
        boolean flag = true;
        for(int i=0;i<dif.length;i++) {
        	for(int j=i;j<dif.length;j++) {
        		sum += dif[j];
        		if(sum<0) {
        			flag=false;
        			break;
        		}
        	}
        	if(flag) {
        		for(int j=0;j<i;j++) {
        			sum+=dif[j];
        			if(sum<0) {
        				flag=false;
        				break;
        			}
        		}
        		if(flag) {
        			return i;
        		}
        	}
        	sum=0;
        	flag = true;
        }
    	return -1;
	}

}
