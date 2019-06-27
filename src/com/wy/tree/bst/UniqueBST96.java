package com.wy.tree.bst;
/*
 * ����1...n������������bst��һ�������ֿ�����
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
	For example,
	Given n = 3, there are a total of 5 unique BST's.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   ��̬�滮���⡣
  	������Ĺؼ���1 BST����ߵ������ȸ�С���ұߵ������ȸ�����ˣ�kΪ���ڵ�ʱ����ߵ���Ϊ1..k-1,�ұߵ���Ϊk+1...n 
  				 2 ��ĳ���ڵ�Ϊ���ڵ��BST������=������BST�Ŀ�����*������BST�Ŀ����ԣ��˷���ϣ�
  				 2 n������ÿ���ڵ㶼���ܳ�Ϊ���ڵ㣬�ۼ��������ɡ�count[i]��ʾi���ڵ��bst������
  				 
  	��⣺G(n)��ʾn���ڵ���ʱ��bst����
  		 F(i,n)��ʾ��iΪ���ڵ��bst������i=1....n
  		 G(n)=F(1,n)+F(2,n)+...F(n,n)  G(0)=G(1)=1
  		 F(i,n)=G(i-1)*G(n-i)   i=1....n
  		 ===>G(n) = G(0)*G(n-1)+G(1)*G(n-2)+��+G(n-1)*G(0) 
 */

//ʱ�临�Ӷ�O(n^2) �ռ�O(n)
public class UniqueBST96 {
	
	public int numTree(int n) {
		int[] G = new int[n+1];
		G[0]=G[1]=1;
		//�ӽڵ���2��ʼ���㵽n
		for(int i=2;i<=n;i++) {
			for(int j=0;j<i;j++) {
				G[i] = G[i]+G[j]*G[i-1-j];
			}
		}
		return G[n];
	}
	
	public int numTrees1(int n) {
        if(n==0 || n==1) {
        	return 1;
        }
        int[] count= new int[n+1];
        count[0] = 1;
        for(int num=1;num<=n;num++) {
        	for(int i=0;i<=num-1;i++) {
        		count[num] = count[num] + count[i]*count[num-1-i];
        	}
        }
        return count[n];
    }
}
