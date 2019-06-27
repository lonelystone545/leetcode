package com.wy.tree.recursion;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ���������·�������ڵ㵽Ҷ�ڵ㣩���Ƿ���ڵ���sum
 * ����û��˵���ڵ��ֵΪ�����������Ա��뵽Ҷ�ڵ���ܽ����ж�
 */
public class PathSum {
	//�ݹ�ⷨ
	public boolean hasPathSum2(TreeNode root, int sum) {
       if(root==null) {
    	   return false;
       } else if(root.left==null && root.right==null) {
    	   return sum==root.val;
       } else {
    	   return hasPathSum2(root.left, sum-root.val) || hasPathSum2(root.right, sum-root.val);
       }
    }
	
	//�ǵݹ�ⷨ �������У��ֱ�洢�ڵ�͸��ڵ㵽�ýڵ��sumֵ
	public boolean hasPathSum(TreeNode root,int sum) {
		if(root==null) return false;
		Queue<TreeNode> nodes = new LinkedList<>();
		Queue<Integer> values = new LinkedList<>();
		nodes.offer(root);
		values.offer(root.val);
		while(!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			int sumvalue = values.poll();
			if(node.left==null&&node.right==null&&sum==sumvalue) {
				return true;
			}
			if(node.left!=null) {
				nodes.offer(node.left);
				values.offer(sumvalue+node.left.val);
			}
			if(node.right!=null) {
				nodes.offer(node.right);
				values.offer(sumvalue+node.right.val);
			}
		}
		return false;
	}
}
