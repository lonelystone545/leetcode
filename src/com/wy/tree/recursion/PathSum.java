package com.wy.tree.recursion;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 求二叉树的路径（根节点到叶节点）和是否存在等于sum
 * 该题没有说明节点的值为正整数，所以必须到叶节点才能进行判断
 */
public class PathSum {
	//递归解法
	public boolean hasPathSum2(TreeNode root, int sum) {
       if(root==null) {
    	   return false;
       } else if(root.left==null && root.right==null) {
    	   return sum==root.val;
       } else {
    	   return hasPathSum2(root.left, sum-root.val) || hasPathSum2(root.right, sum-root.val);
       }
    }
	
	//非递归解法 两个队列，分别存储节点和根节点到该节点的sum值
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
