package com.wy.tree.traversal;

import java.util.Stack;

/**
 * 判断两棵树是否相同
 */

public class IsSameTree {
	
	//递归 时间O(n) 空间O(logn)
	public boolean isSameTree(TreeNode p,TreeNode q) {
		if(p==null && q==null) return true;
		if(p==null || q==null) return false;
		return (p.val==q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
	//迭代实现
	public boolean isSameTree2(TreeNode p,TreeNode q) {
//		if(p==null && q==null) return true;
//		if(p==null || q==null) return false;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(p);
		stack.push(q);
		while(!stack.isEmpty()) {
			q=stack.pop();
			p=stack.pop();
			if(p==null && q==null) continue;
			if(p==null || q==null) return false;
			if(p.val!=q.val) return false;
			
			stack.push(p.left);
			stack.push(q.left);
			
			stack.push(p.right);
			stack.push(q.right);
		}
		return true;
	}
}
