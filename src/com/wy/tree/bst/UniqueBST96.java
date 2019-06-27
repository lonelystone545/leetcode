package com.wy.tree.bst;
/*
 * 给定1...n的整数，构建bst，一共多少种可能性
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
	For example,
	Given n = 3, there are a total of 5 unique BST's.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   动态规划问题。
  	此问题的关键：1 BST，左边的树都比根小，右边的树都比根大。因此，k为根节点时，左边的树为1..k-1,右边的树为k+1...n 
  				 2 以某个节点为根节点的BST可能性=左子树BST的可能性*右子叔BST的可能性（乘法组合）
  				 2 n个数，每个节点都可能成为根节点，累加起来即可。count[i]表示i个节点的bst数量。
  				 
  	求解：G(n)表示n个节点数时的bst数量
  		 F(i,n)表示以i为根节点的bst数量，i=1....n
  		 G(n)=F(1,n)+F(2,n)+...F(n,n)  G(0)=G(1)=1
  		 F(i,n)=G(i-1)*G(n-i)   i=1....n
  		 ===>G(n) = G(0)*G(n-1)+G(1)*G(n-2)+…+G(n-1)*G(0) 
 */

//时间复杂度O(n^2) 空间O(n)
public class UniqueBST96 {
	
	public int numTree(int n) {
		int[] G = new int[n+1];
		G[0]=G[1]=1;
		//从节点数2开始计算到n
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
