package com.wy.tree.traversal;


public class PopulatingNextRightPointers117 {
	
	/*
	 * ˼·���������ƣ�ͬ�����ڱ����ϲ�ڵ�ʱ��ȥ�����һ��ڵ�����ӹ���
	 * ��ͬ���ǣ�����ֻ��һ����ͨ�Ķ������ˡ�������ȷ��next�ڵ��ֵʱ����Ҫ�����Һ��Ӷ������жϣ��ҵ�����ڵ�
	 * ��Σ�Ҫ�ж��������ӻ����Һ��ӣ��ٽ�����Ӧ������
	 */
	 public void connect(TreeLinkNode root) {
		 if(root==null) return;
		 TreeLinkNode parent =root;
		 //�����ÿ��ڵ���б���������
		 TreeLinkNode pre;;
		 //ָ��ÿ�������ڵ�
		 TreeLinkNode next;;
		 while(parent!=null) {
			 pre = null;
			 next = null;
			 //��ÿ��ڵ�ı���ѭ��
			 while(parent!=null) {
				 //��next��ֵ
				 if(next==null) {
					 if(parent.left!=null) {
						 next = parent.left;
					 } else {
						 //�����Һ��ӽڵ��Ƿ�Ϊ��
						 next = parent.right;
					 }
				 }
				 
				 if(parent.left!=null) {
					 if(pre!=null) {
						 //�縸�ڵ��������
						 pre.next = parent.left;
						 pre = pre.next;
					 } else {
						 pre = parent.left;
					 }
				 }
				 if(parent.right!=null) {
					 if(pre!=null) {
						 //ͬһ�����ڵ���������ӽ�������
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
	  * ����һ���ڵ�dummyNode��ʹ����next�ڵ�ָ������ڵ㣬�����Ͳ���ȥ�ж�Ѱ������ڵ�
	  * һ����˵��dummyNode����һ�ڵ�ָ��ͷ�ڵ㣬��������ʹ�������е����нڵ㣨����ͷ�ڵ㣩����һ���ģ���Ϊ����ʹͷ�ڵ�����ǰ��
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
