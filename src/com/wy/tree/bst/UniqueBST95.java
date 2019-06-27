package com.wy.tree.bst;
/*
 *Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

	For example,
	Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   	�������֪�����е�BST������Ӧ�Ŀ���������������������е�����˼·�ǲ��õݹ顣
   	ÿ��ѡȡһ���ڵ���Ϊ���ڵ㣬Ȼ��ݹ�������������Ľ���������������������ص���������������ѡȡȻ�����Ӽ��ɡ�
 */
import java.util.ArrayList;
import java.util.List;

public class UniqueBST95 {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(n==0) return res;
		
        return helper(1,n); //�ӽڵ�1��ʼ���ڵ�n���ֱ���Ϊroot�ڵ�
    }

	private List<TreeNode> helper(int start, int end) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(start>end) {
			res.add(null);
			return res;
		}
		
		//��i��Ϊ���ڵ�
		for(int i=start;i<=end;i++) {
			List<TreeNode> left = helper(start,i-1); //��������start...i-1����
			List<TreeNode> right = helper(i+1,end); //��������i+1....end����
			//nullҲ�ǿ��Ա�������
			for(TreeNode l : left) {
				for(TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}
	
}
