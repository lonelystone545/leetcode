package com.wy.tree.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigzagLevelOrder {
	//������������󣬶���Ҫ��ת�Ĳ���з�ת 
	//Ҳ���԰ѷ�ת�ŵ�ÿ�������ռ���֮�����
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root==null) return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> level = new ArrayList<Integer>();
				for(int i=0;i<size;i++) {
					TreeNode tmp = queue.poll();
					level.add(tmp.val);
					if(tmp.left!=null) {
						queue.offer(tmp.left);
					}
					if(tmp.right!=null) {
						queue.offer(tmp.right);
					}
				}
			result.add(level);
		}
		for(int i=0;i<result.size();i++) {
			if(i%2!=0) {
				Collections.reverse(result.get(i));
			}
		}
		return result;
	}
	
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root==null) {
			return result;
		}
		
		Stack<TreeNode> currLevel = new Stack<>();
		Stack<TreeNode> nextLevel = new Stack<>();
		Stack<TreeNode> tmp;
		
		currLevel.push(root);
		boolean normalOrder = true;
		while(!currLevel.isEmpty()) {
			List<Integer> currLevelResult = new ArrayList<>();
			
			while(!currLevel.isEmpty()) {
				TreeNode node = currLevel.pop();
				currLevelResult.add(node.val);
				
				if(normalOrder) {
					//���ӽڵ��Ƚ�ջ
					if(node.left!=null) {
						nextLevel.push(node.left);
					}
					if(node.right!=null) {
						nextLevel.push(node.right);
					}
				} else {
					if(node.right!=null) {
						nextLevel.push(node.right);
					}
					if(node.left!=null) {
						nextLevel.push(node.left);
					}
				}
			}
			result.add(currLevelResult);
			//����ջ
			tmp=currLevel;
			currLevel=nextLevel;
			nextLevel=tmp;
			normalOrder=!normalOrder;
		}
		return result;
	}
}
