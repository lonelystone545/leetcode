package com.wy.tree.traversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null) return result; //·µ»Ø[]
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode tmp = stack.peek();
			if(tmp.left==null && tmp.right==null) {
				stack.pop();
				result.add(tmp.val);
			} else {
				if(tmp.right!=null) {
					stack.push(tmp.right);
					tmp.right=null;
				}
				if(tmp.left!=null) {
					stack.push(tmp.left);
					tmp.left=null;
				}
			}
		}
		return result;
	}
	
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null) return result; //·µ»Ø[]
		Stack<TreeNode> stack = new Stack<TreeNode>();
		HashSet<TreeNode> hs = new HashSet<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			if(hs.contains(tmp)){
				result.add(tmp.val);
				continue;
			}
			hs.add(tmp);
			stack.push(tmp);
			if(tmp.right!=null) {
				stack.push(tmp.right);
			}
			if(tmp.left!=null) {
				stack.push(tmp.left);
			}
		}
		return result;
	}
}
