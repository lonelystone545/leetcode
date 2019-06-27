package com.wy.tree.traversal;


public class PopulatingNextRightPointers117 {
	
	/*
	 * 思路与上题类似，同样是在遍历上层节点时，去完成下一层节点的链接过程
	 * 不同的是，这里只是一棵普通的二叉树了。首先在确定next节点的值时，需要对左右孩子都进行判断，找到最左节点
	 * 其次，要判断是有左孩子还是右孩子，再进行相应的链接
	 */
	 public void connect(TreeLinkNode root) {
		 if(root==null) return;
		 TreeLinkNode parent =root;
		 //负责对每层节点进行遍历并链接
		 TreeLinkNode pre;;
		 //指向每层的最左节点
		 TreeLinkNode next;;
		 while(parent!=null) {
			 pre = null;
			 next = null;
			 //对每层节点的遍历循环
			 while(parent!=null) {
				 //对next赋值
				 if(next==null) {
					 if(parent.left!=null) {
						 next = parent.left;
					 } else {
						 //不管右孩子节点是否为空
						 next = parent.right;
					 }
				 }
				 
				 if(parent.left!=null) {
					 if(pre!=null) {
						 //跨父节点进行链接
						 pre.next = parent.left;
						 pre = pre.next;
					 } else {
						 pre = parent.left;
					 }
				 }
				 if(parent.right!=null) {
					 if(pre!=null) {
						 //同一个父节点的两个孩子进行链接
						 pre.next = parent.right;
						 pre = pre.next;
					 } else {
						 pre = parent.right;
					 }
				 }
				 parent = parent.next;
			 }
			 parent = next;
		 }
	 }
	 
	 /*
	  * 引用一个节点dummyNode，使它的next节点指向最左节点，这样就不用去判断寻找最左节点
	  * 一般来说，dummyNode的下一节点指向头节点，这样就能使二叉树中的所有节点（包括头节点）都是一样的，因为这样使头节点有了前驱
	  */
	 public void connect2(TreeLinkNode root) {
		 if(root == null) return ;
		 
		 TreeLinkNode parent = root;
		 while(parent!=null) {
			 TreeLinkNode dummyNode = new TreeLinkNode(-1);
			 TreeLinkNode pre = dummyNode;
			 while(parent!=null) {
				 if(parent.left!=null) {
					 pre.next = parent.left;
					 pre = parent.left;
				 }
				 if(parent.right!=null) {
					 pre.next = parent.right;
					 pre = parent.right;
				 }
				 parent = parent.next;
			 }
			 parent = dummyNode.next;
		 }
	 }
}
