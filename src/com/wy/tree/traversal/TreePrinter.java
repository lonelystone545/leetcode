package com.wy.tree.traversal;
/*
 * 二叉树的层序遍历
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreePrinter {
	 public List<List<Integer>> printTree(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root==null) return result;
		//使用队列实现
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		//入队列
		queue.offer(root);
		while(!queue.isEmpty()) {
			//存放一层的数据
			ArrayList<Integer> level = new ArrayList<Integer>();
			int length = queue.size();
			for(int i=0;i<length;i++) {
				//弹出队列
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
