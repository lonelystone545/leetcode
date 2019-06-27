package com.wy.tree.traversal;
/*
 * 判断是否为平衡二叉树
 * 时间复杂度O(n) 空间O(logn)
 */
public class IsBalanced {
	public boolean isBalanced(TreeNode root) {
		if(getHeight(root)==-1) {
			return false;
		} else {
			return true;
		}
	}

	private int getHeight(TreeNode root) {
		if(root==null) return 0;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if(left==-1 || right==-1 || Math.abs(left-right)>1) {
			return -1;
		}
		return Math.max(left, right)+1;
	}
}
