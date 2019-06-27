package com.wy.array;

import java.util.ArrayList;
import java.util.List;

/*
 * 60. Permutation Sequence 
 *  The set [1,2,3,��,n] contains a total of n! unique permutations.
	By listing and labeling all of the permutations in order,
	We get the following sequence (ie, for n = 3): 
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"

	Given n and k, return the kth permutation sequence.
	Note: Given n will be between 1 and 9 inclusive.
	
	n������ɵ�ȫ���У�����n!�֡�������λ�̶�����ô����(n-1)!�����С�
	�ؼ��������ÿ�λ�ȡ���λ�أ����Ҫ�ҵ��ǵ�k�����У���ʱ�ǰ�1..n�洢��list�����У�
	��ôindex=(k-1)/(n-1)!���ɣ��뼯���е��±��Ӧ�����Ի�ö�Ӧ��Ԫ��ֵ��
	kֵ�ĸ���:k=k-index*(n-1)!,���ǰ�ǰ�����ȫ����ȥ����k=k%(n-1)!
	 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
        //���1..n����
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		//���1..n�Ľ׳���
		int[] factorial = new int[n+1];
		
		factorial[0]=1;
		int sum=1;
		for(int i=1;i<=n;i++) {
			sum = sum*i;
			factorial[i] = sum;
		}
		
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		
		k--;
		for(int i=1;i<=n;i++) {
			//����ȡ����1,2..nλ����
			int index = k/factorial[n-i];
			sb.append(String.valueOf(list.get(index)));
			//�Ƴ�����
			list.remove(index);
			k = k-index*factorial[n-i];
		}
		return sb.toString();
    }
}
