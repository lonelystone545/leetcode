package com.wy.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return check(root.left,root.right);
    }

	private boolean check(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}
		if(root1.val != root2.val) {
			return false;
		}
		return check(root1.left,root2.right) && check(root1.right,root2.left);
	}
	
	//非递归解法
	public boolean isSymmetric2(TreeNode root) {
		if(root == null) return true;
		if(root.left==null && root.right==null) return true;
		if(root.left ==null || root.right == null) return false;
		
		LinkedList<TreeNode> q1 = new LinkedList<>();
		LinkedList<TreeNode> q2 = new LinkedList<>();
		q1.add(root.left);
		q2.add(root.right);
		
		while(!q1.isEmpty() && !q2.isEmpty()) {
			TreeNode n1 = q1.poll();
			TreeNode n2 = q2.poll();
			
			if(n1.val!=n2.val) return false;
			if((n1.left==null &&n2.right!=null) || (n1.left!=null&&n2.right==null)){
				return false;
			}
			if((n1.right==null &&n2.left!=null) || (n1.right!=null&&n2.left==null)){
				return false;
			}
			
			if(n1.left!=null && n2.right!=null) {
				q1.add(n1.left);
				q2.add(n2.right);
			}
			if(n1.right!=null && n2.left!=null) {
				q1.add(n1.right);
				q2.add(n2.left);
			}
		}
		return true;
	}
	
	public boolean isSymmetric3(TreeNode root) {
		if(root == null) return true;
		//此处用栈也可以
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		//即便拿到的是null queue的size也加1
		queue.offer(root.left);
		queue.offer(root.right);
		while(!queue.isEmpty()) {
			TreeNode node1 = queue.poll();
			TreeNode node2 = queue.poll();
			if(node1==null && node2==null) continue;
			if(node1==null || node2==null) return false;
			if(node1.val!=node2.val) return false;
			
			queue.offer(node1.left);
			queue.offer(node2.right);
			
			queue.offer(node1.right);
			queue.offer(node2.left);
			
		}
		return true;
	}
}
