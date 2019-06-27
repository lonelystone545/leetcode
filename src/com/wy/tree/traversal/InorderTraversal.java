package com.wy.tree.traversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*
 * �������
 */
public class InorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null) return result;
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!stack.isEmpty() || node!=null) {
			if(node!=null) {
				stack.push(node);
				node=node.left;
			} else {
				TreeNode tmp = stack.pop();
				result.add(tmp.val);
				node = tmp.right;
			}
		}
		return result;
	}
	
	List<Integer> result = new ArrayList<Integer>();
	public List<Integer> inorderTraversal2(TreeNode root) {
		//�ݹ�ʵ��
		if(root!=null) {
			helper(root);
		}
		return result;
	}
	public void helper(TreeNode p) {
		if(p.left!=null) {
			helper(p.left);
		}
		result.add(p.val);
		if(p.right!=null) {
			helper(p.right);
		}
	}
	
	public List<Integer> inorderTraversal3(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result;
		}
		Stack<TreeNode> stack =new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode top = stack.peek(); //������ջ���鿴ջ��Ԫ��
			if(top.left!=null) {
				stack.push(top.left);
				top.left=null;
			} else {
				result.add(top.val);
				stack.pop();
				if(top.right!=null){
					stack.push(top.right);
				}
			}
		}
		return result;
	}
	
	//��һ�η��ʽڵ�ʱ��չ���������Լ�������ջ���ڶ��δ�ջ�з�����������
	public List<Integer> inorderTraversal4(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root==null) return result;
		//����hashset�ж��Ƿ���ʹ�
		HashSet<TreeNode> hs = new HashSet<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			if(hs.contains(tmp)) {
				result.add(tmp.val);
				continue;
			}
			hs.add(tmp);
			if(tmp.right!=null) {
				stack.push(tmp.right);
			}
			stack.push(tmp);
			if(tmp.left!=null) {
				stack.push(tmp.left);
			}
		}
		return result;
	}
}
