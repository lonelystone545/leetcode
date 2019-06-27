package com.wy.tree.recursion;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 求二叉树的深度
 * 时间o(n) 空间o(logn)
 */
public class MaximumDepthofBT {
	public int maxDepth2(TreeNode root) {
        if(root==null) return 0;
		int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        return Math.max(leftdepth, rightdepth)+1;
    }
	
	//层序遍历
	//思想：curnum记录当前层节点个数， nextnum记录下一层节点个数 ，遍历完一层depth++,层序遍历肯定是遍历到最底层 
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int curnum = 1;
		int nextnum = 0;
		//记录深度
		int depth = 0;
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			curnum--;
			if(node.left!=null) {
				queue.offer(node.left);
				nextnum++;
			}
			if(node.right!=null) {
				queue.offer(node.right);
				nextnum++;
			}
			if(curnum==0) {
				curnum=nextnum;
				nextnum=0;
				depth++;
			}
		}
		return depth;
	}
}
