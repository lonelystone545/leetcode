package com.wy.tree.recursion;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ������������
 * ʱ��o(n) �ռ�o(logn)
 */
public class MaximumDepthofBT {
	public int maxDepth2(TreeNode root) {
        if(root==null) return 0;
		int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        return Math.max(leftdepth, rightdepth)+1;
    }
	
	//�������
	//˼�룺curnum��¼��ǰ��ڵ������ nextnum��¼��һ��ڵ���� ��������һ��depth++,��������϶��Ǳ�������ײ� 
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int curnum = 1;
		int nextnum = 0;
		//��¼���
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
