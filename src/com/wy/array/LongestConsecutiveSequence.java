package com.wy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 *  128. Longest Consecutive Sequence 
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence. 
	For example,
	Given [100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4. 
	Your algorithm should run in O(n) complexity. 
	
	
	�����ʱ�临�Ӷ�û��Ҫ�󣬿�����������������������
	����Ҫ��O(n)���Ͳ���ʹ�������ˡ�
	��������������ģ���Ҫ��O(n)��Ӧ���뵽��ϣ����߼��ϡ�
 */
public class LongestConsecutiveSequence {
	
	/*
	 * ʹ��map���ϣ����洢Ԫ�أ�ֵ�洢��Ӧ����������
	 * ���������ȷ����仯ʱ��Ҫ��Ӧ�ĸ��µ���β����ֵ
	 * ��Ϊ�´ν����ж�ȡ��ʱ���Ǹ�����β���еģ��м��ֵ����ν
	 * ��{1,2,3} map.get(1)��map.get(3)���صĶ���3
	 */
	public int longestConsecutive2(int[] nums) {
		int res = 0;//��¼��󳤶�
		Map<Integer,Integer> map = new HashMap<>();
		for(int n: nums) {
			if(!map.containsKey(n)) {
				//���������(��)ֵ����ȡ����Ӧ��ֵ(��������)
				int left = (map.containsKey(n-1))? map.get(n-1):0;
				int right = (map.containsKey(n+1))? map.get(n+1):0;
				// ���ϱ������'1'
				int sum = left+right+1;
				//�������ݼ���Ӧ����������
				map.put(n,sum);
				res = Math.max(res, sum);
				
				//Ŀ���Ǹ����������ȵ�ͷ��β��ֵ
				map.put(n-left, sum);
				map.put(n+right, sum);
				
			} else {
				//����Ѿ������˸�ֵ���������ô�ѭ��
				continue;
			}
		}
		return res;
	}
	
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		//�������е�Ԫ�ؼ��뵽������
		for(int n:nums) {
			set.add(n);
		}
		int length = 0;
		//��������
		for(int n :nums) {
			if(set.contains(n)) {
				int count = 1;
				//��Ԫ��nɾ��
				set.remove(n);
				
				int left = n-1;
				while(set.contains(left)){
					count++;
					set.remove(left);
					left--;
				}
				int right = n+1;
				while(set.contains(right)){
					count++;
					set.remove(right);
					right++;
				}
				length = Math.max(length, count);
			}
		}
		return length;
	}
}
