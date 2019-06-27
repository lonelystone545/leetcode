package com.wy.tree.traversal;

import java.util.ArrayList;
import java.util.List;

/*
 * �޸�BST
 * BST�����������ڵ����Ľ����ˣ����ҳ���������
 *  1 ���ڽڵ���н���ʱ��ֻ�����һ�����
 *  2 �����ڽڵ���н���ʱ��������������
 *  	��һ�γ��ִ��������������һ�������ɺ��������������
 *  	�ڶ��γ��ִ�������������ڶ���������ǰ�������������
 *  ���ӣ� 12345678 ����12435678    1284563
 */
public class RecoverTree {
	/*
	 * ʹ��first��second�ڵ��¼�������󽻻��Ľڵ�
	 * ʹ��pre�ڵ��¼�������ʱ����ǰ�ڵ��ǰ���ڵ�
	 * ʱ��O(n) �ռ�O(1)
	 */
	private TreeNode first = null;
	private TreeNode second = null;
	private TreeNode pre = new TreeNode(Integer.MIN_VALUE);//Ϊ���뵱ǰ�ڵ���бȽ�
	
	public void recoverTree(TreeNode root) {
		traverse(root);	
		//����
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}
	
	//������� ���Ҵ���������ڵ�
	private void traverse(TreeNode root) {
		if(root==null)return;
		traverse(root.left);
		//��first���и�ֵ���˺�Ͳ��ٸı�
		if(first==null && root.val<pre.val) {
			first = pre;  //���ֵ�Ǵ����
		}
		//first��ֵ�󣬲Ŷ�second���и�ֵ
		if(first!=null && root.val<pre.val) {
			second = root; //С��ֵ�Ǵ����
		}
		pre=root;
		traverse(root.right);
	}
	
	
	//��ͨ������ʱ��O(n) �ռ�O(n)����
	public void recoverTree2(TreeNode root) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		inOrder(root,res);
		//���������֮������д�������
		TreeNode[] arr = new TreeNode[res.size()];
		int i=0;
		for(TreeNode r : res) {
			arr[i++] = r;
		}
		
		//���Ҵ����Ԫ��
		int first = 0;
		int second = 0;
		//��ǰ������ҵ�һ�������λ��
		for( i=0;i<arr.length;i++) {
			if(arr[i].val>arr[i+1].val && i<arr.length-1) {
				first=i;
				break;
			}
		}
		//�Ӻ���ǰ���ҵڶ��������λ��
		for(i=arr.length-1;i>=0;i--) {
			if(arr[i].val<arr[i-1].val && i>0) {
				second = i;
				break;
			}
		}
		
		//����
		arr[first].val = arr[first].val ^ arr[second].val;
		arr[second].val = arr[first].val ^ arr[second].val;
		arr[first].val = arr[first].val ^ arr[second].val;
	}

	private void inOrder(TreeNode root, List<TreeNode> res) {
		if(root==null) return;
		
		inOrder(root.left,res);
		res.add(root);
		inOrder(root.right,res);
	}
}
