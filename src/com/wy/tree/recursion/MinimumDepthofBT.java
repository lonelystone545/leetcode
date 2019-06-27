package com.wy.tree.recursion;

import java.util.LinkedList;
import java.util.Queue;

/*
 * �����������С���
 * ��С��ȣ��Ӹ��ڵ㵽Ҷ�ڵ��߹������·��
 * ע�⣺����ֱ�ӽ����������ȵ�max��Ϊmin����Ϊ���һ���ڵ�����û������������ôӦ�÷��������������.
 * ����Ӧ�ö��Ƿ�ΪҶ�ڵ�����жϡ�
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
	
	//�ǵݹ�ⷨ
	public int minDepth(TreeNode root) {
		if(root==null) return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		//������Ҳ�����
		int level=1;
		int nlevelnum = 0;
		int curlevelnum = 1;
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			//��Ҷ�ڵ� ֱ�ӷ���
			if(node.left==null && node.right==null) {
				return level;
			}
			//��ǰ��ڵ���-1
			curlevelnum--;
			if(node.left!=null) {
				queue.offer(node.left);
				//��һ��ڵ���+1
				nlevelnum++;
			}
			if(node.right!=null) {
				queue.offer(node.right);
				//��һ��ڵ���+1
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
