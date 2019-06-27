package com.wy.array;

import java.util.ArrayList;
import java.util.List;

/*
 * 60. Permutation Sequence 
 *  The set [1,2,3,…,n] contains a total of n! unique permutations.
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
	
	n个数组成的全排列，共有n!种。如果最高位固定，那么就有(n-1)!种排列。
	关键在于如何每次获取最高位呢？如果要找的是第k个排列，此时是把1..n存储到list集合中，
	那么index=(k-1)/(n-1)!即可，与集合中的下标对应，可以获得对应的元素值。
	k值的更新:k=k-index*(n-1)!,就是把前面的数全部除去，或k=k%(n-1)!
	 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
        //存放1..n个数
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		//存放1..n的阶乘数
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
			//依次取出第1,2..n位上数
			int index = k/factorial[n-i];
			sb.append(String.valueOf(list.get(index)));
			//移除该数
			list.remove(index);
			k = k-index*factorial[n-i];
		}
		return sb.toString();
    }
}
