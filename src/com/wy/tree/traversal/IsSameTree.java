package com.wy.tree.traversal;

import java.util.Stack;

/**
 * �ж��������Ƿ���ͬ
 */

public class IsSameTree {
	
	//�ݹ� ʱ��O(n) �ռ�O(logn)
	public boolean isSameTree(TreeNode p,TreeNode q) {
		if(p==null && q==null) return true;
		if(p==null || q==null) return false;
		return (p.val==q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
	//����ʵ��
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
