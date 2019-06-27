package com.wy.tree.recursion;
/*
 * Given a binary tree, find the maximum path sum. 
   For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
   For example:
   Given the below binary tree, 
       1
      / \
     2   3

  Return 6. 
  
 �ڶ�������������һ���ڵ㵽����һ���ڵ�·���͵����ֵ�����Բ��������ڵ㣩
 
 ע�⣺1 Ҫ���ǵ��ڵ�ֵΪ���������
 	  2 ʹ�õݹ飬�²����ϲ㷵��ֵ�����������ֻ��ѡ��һ����֧��������ڵ��ֵ  ����ڵ��ֵ+���ӽڵ��ֵ  ����ڵ��ֵ+���ӽڵ��ֵ
 	  3 ��ÿ�α���ʱ��Ҫ�����ֵ��¼�����µ�һ��ȫ�ֱ������������С�maxΪ����ڵ�+���ӽڵ�+���ӽڵ��ֵ�ͷ���ֵ�еĽϴ���
 */
public class BinaryTreeMaximumPathSum {
	
	//ʱ��O(n)  �ռ�O(logn)���
	public int maxPathSum(TreeNode root) {
		if(root ==null) return 0;
		int[] max = new int[1];
		//������¼ÿ�εݹ������ֵ
		//ʹ���������ͣ��������ݹ�֮��ֵ�ǿ���һֱ����ģ�Ҳ����ʹ�ó�Ա������Ϊȫ�ֱ���ʹ��
		max[0] = Integer.MIN_VALUE;
		helper(root,max);
		return max[0];
	}

	private int helper(TreeNode root, int[] max) {
		if(root==null) return 0;
		
		int left = helper(root.left,max);
		int right = helper(root.right,max);
		
		//��Ϊ�򸸽ڵ�ķ���ֵ��ֻ��ѡһ����֧�������������1����ڵ��ֵ��� 2���ӽڵ�+����ڵ�ֵ��� 3���ӽڵ�+����ڵ�ֵ���
		int res = Math.max(root.val, Math.max(left+root.val, right+root.val));
		//����max�����ֵ����ʱ��Ҫ��left+right+root.val�Ƚϣ�ȡ���
		max[0] = Math.max(Math.max(res, left+right+root.val), max[0]);
		return res;
	}
}
