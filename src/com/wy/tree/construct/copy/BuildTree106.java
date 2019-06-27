package com.wy.tree.construct.copy;
/*
 * 根据中序遍历和后序遍历构建一棵二叉树
 */
public class BuildTree106 {
	public TreeNode buildTree(int[] inorder,int[] postorder) {
		int inLength = inorder.length;
		int postLength = postorder.length;
		return helper(inorder,0,inLength-1,postorder,0,postLength-1);
	}

	private TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
		if(instart>inend || poststart>postend) {
			return null;
		}
		int rootval = postorder[postend];
		int rootIndex = 0;
		for(int i=0;i<=inend;i++) {
			if(inorder[i]==rootval) {
				rootIndex = i;
				break;
			}
		}
		int len = inend-rootIndex;
		TreeNode root = new TreeNode(rootval);
		root.left = helper(inorder,instart,rootIndex-1,postorder,poststart,postend-len-1);
		root.right = helper(inorder,rootIndex+1,inend,postorder,postend-len,postend-1);
		return root;
	}
	
	private TreeNode helper2(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
		if(instart>inend || poststart>postend) {
			return null;
		}
		int rootval = postorder[postend];
		int rootIndex = 0;
		for(int i=0;i<=inend;i++) {
			if(inorder[i]==rootval) {
				rootIndex = i;
				break;
			}
		}
		int len = rootIndex-instart;
		TreeNode root = new TreeNode(rootval);
		root.left = helper(inorder,instart,rootIndex-1,postorder,poststart,poststart+len-1);
		root.right = helper(inorder,rootIndex+1,inend,postorder,poststart+len,postend-1);
		return root;
	}
}	
