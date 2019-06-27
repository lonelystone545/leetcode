package com.wy.tree.traversal;
/*
 * �������Ĳ������
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreePrinter {
	 public List<List<Integer>> printTree(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root==null) return result;
		//ʹ�ö���ʵ��
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		//�����
		queue.offer(root);
		while(!queue.isEmpty()) {
			//���һ�������
			ArrayList<Integer> level = new ArrayList<Integer>();
			int length = queue.size();
			for(int i=0;i<length;i++) {
				//��������
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
		return result;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int value) {
		this.val = value;
	}
}
