package com.wy.tree.traversal;
/*
 * Morris算法遍历二叉树 
 * 使用的是线索二叉树 
 */
import java.util.ArrayList;
import java.util.List;

public class MorrisTreePrinter {
	
	//中序遍历
	public List<Integer> morrisInOrder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null) return result; //返回[]
		
		TreeNode cur = root;
		while(cur!=null) {
			if(cur.left==null) {
				result.add(cur.val);
				cur=cur.right;
			} else {
				TreeNode tmp = cur.left;
				while(tmp.right!=null && tmp.right!=cur) {
					tmp = tmp.right; //找到左子树的最右节点
				}
				if(tmp.right==null) {
					tmp.right=cur;
					cur=cur.left;
				} else {
					result.add(cur.val);
					tmp.right=null;
					cur=cur.right;
				}
			}
		}
		return result;
	}
	
	//前序遍历
	public List<Integer> morrisPreOrder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null) return result; //返回[]
		TreeNode cur = root;
		while(cur!=null) {
			if(cur.left==null) {
				result.add(cur.val); //输出当前节点
				cur=cur.right;
			} else {
				TreeNode tmp = cur.left;
				//找左子树的最右节点
				while(tmp.right!=null && tmp.right!=cur) {
					tmp=tmp.right;
				}
				if(tmp.right==null){
					result.add(cur.val); //输出当前节点
					tmp.right = cur;
					cur=cur.left;
				} else {
					tmp.right=null; //恢复二叉树
					cur=cur.right;
				}
			}
		}
		return result;
	}
	
	//后序遍历
	public List<Integer> morrisPostOrder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null)  return result;
		TreeNode tmpNode = new TreeNode(-1); //建立一个临时节点
		tmpNode.left = root;//临时节点的左子节点指向root
		TreeNode cur = tmpNode;
		while(cur!=null) {
			if(cur.left==null) {
				cur = cur.right;
			} else {
				TreeNode tmp = cur.left;
				while(tmp.right!=null && tmp.right!=cur) 
					tmp = tmp.right;
				if(tmp.right==null) {
					tmp.right=cur;
					cur=cur.left;
				} else {
					tmp.right=null;
					TreeNode t = cur.left;
					List<Integer> tmpList = new ArrayList<>();
					while(t!=null) { //倒序输出
						tmpList.add(0,t.val); //在指定位置上插入元素，向右移动该位置上原先的元素及后续元素
						t = t.right;
					}
					result.addAll(tmpList);
					cur=cur.right;
				}
			}
		}
		return result;
	}
}
