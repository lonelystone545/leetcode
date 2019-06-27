package com.wy.tree.traversal;

import java.util.ArrayList;
import java.util.List;

/*
 * 修复BST
 * BST树中有两个节点错误的交换了，查找出来并修正
 *  1 相邻节点进行交换时，只会出现一组错序
 *  2 非相邻节点进行交换时，会出现两组错序。
 *  	第一次出现错序的两个数，第一个数是由后面的数交换过来
 *  	第二次出现错序的两个数，第二个数是由前面的数交换过来
 *  例子： 12345678 错序12435678    1284563
 */
public class RecoverTree {
	/*
	 * 使用first和second节点记录两个错误交换的节点
	 * 使用pre节点记录中序遍历时，当前节点的前驱节点
	 * 时间O(n) 空间O(1)
	 */
	private TreeNode first = null;
	private TreeNode second = null;
	private TreeNode pre = new TreeNode(Integer.MIN_VALUE);//为了与当前节点进行比较
	
	public void recoverTree(TreeNode root) {
		traverse(root);	
		//交换
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}
	
	//中序遍历 查找错误的两个节点
	private void traverse(TreeNode root) {
		if(root==null)return;
		traverse(root.left);
		//对first进行赋值，此后就不再改变
		if(first==null && root.val<pre.val) {
			first = pre;  //大的值是错误的
		}
		//first有值后，才对second进行赋值
		if(first!=null && root.val<pre.val) {
			second = root; //小的值是错误的
		}
		pre=root;
		traverse(root.right);
	}
	
	
	//普通方法：时间O(n) 空间O(n)做法
	public void recoverTree2(TreeNode root) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		inOrder(root,res);
		//将中序遍历之后的序列存入数组
		TreeNode[] arr = new TreeNode[res.size()];
		int i=0;
		for(TreeNode r : res) {
			arr[i++] = r;
		}
		
		//查找错误的元素
		int first = 0;
		int second = 0;
		//从前往后查找第一个逆序的位置
		for( i=0;i<arr.length;i++) {
			if(arr[i].val>arr[i+1].val && i<arr.length-1) {
				first=i;
				break;
			}
		}
		//从后往前查找第二个逆序的位置
		for(i=arr.length-1;i>=0;i--) {
			if(arr[i].val<arr[i-1].val && i>0) {
				second = i;
				break;
			}
		}
		
		//交换
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
