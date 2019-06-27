package com.wy.tree.recursion;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 求二叉树的最小深度
 * 最小深度：从根节点到叶节点走过的最短路径
 * 注意：不能直接将求二叉树深度的max改为min，因为如果一个节点有左没有右子树，那么应该返回右子树的深度.
 * 所以应该对是否为叶节点进行判断。
 */
public class MinimumDepthofBT {
	
	public int minDepth2(TreeNode root) {
       if(root==null) return 0;
       int leftdepth = minDepth2(root.left);
       int rightdepth = minDepth2(root.right);
       if(leftdepth==0) {
    	   return rightdepth+1;
       } else if(rightdepth==0){
    	   return leftdepth+1;
       }
        return Math.min(leftdepth, rightdepth)+1;
    }
	
	public int minDepth3(TreeNode root) {
		if(root==null) return 0;
		if(root.left==null) {
			return minDepth3(root.right)+1;
		}
		if(root.right==null) {
			return minDepth3(root.left)+1;
		}
		return Math.min(minDepth3(root.left), minDepth3(root.right))+1;
	}
	
	//非递归解法
	public int minDepth(TreeNode root) {
		if(root==null) return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		//层数，也是深度
		int level=1;
		int nlevelnum = 0;
		int curlevelnum = 1;
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			//是叶节点 直接返回
			if(node.left==null && node.right==null) {
				return level;
			}
			//当前层节点数-1
			curlevelnum--;
			if(node.left!=null) {
				queue.offer(node.left);
				//下一层节点数+1
				nlevelnum++;
			}
			if(node.right!=null) {
				queue.offer(node.right);
				//下一层节点数+1
				nlevelnum++;
			}
			if(curlevelnum==0) {
				curlevelnum = nlevelnum;
				nlevelnum=0;
				level++;
			}
		}
		return 0;
	}
}
