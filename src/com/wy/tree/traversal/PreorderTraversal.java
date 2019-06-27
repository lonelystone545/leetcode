package com.wy.tree.traversal;
/*
 * 二叉树 前序遍历
 */
import java.util.ArrayList;
/*
 * 前序遍历
 * 使用栈 
 * 时间复杂度O(n) 空间O(n)
 */
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root==null) return result;
		
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode tmp = stack.pop();
			result.add(tmp.val);
			if(tmp.right!=null){
				stack.push(tmp.right);
			}
			if(tmp.left!=null){
				stack.push(tmp.left);
			}
		}
		return result;
    }
}

