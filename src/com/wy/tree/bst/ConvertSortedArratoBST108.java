package com.wy.tree.bst;

/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 注意递归的退出
 * 
 * 二叉查找树（Binary Search Tree），也称有序二叉树（ordered binary tree）,排序二叉树（sorted binary tree），是指一棵空树或者具有下列性质的二叉树：

	若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
	任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
	任意节点的左、右子树也分别为二叉查找树。
	
	平衡二叉树：空树是平衡的，对于非空的树来说，其左子树是平衡的，右子树是平衡的，且左右子树的高度差不大于1.
 */
public class ConvertSortedArratoBST108 {
	 public TreeNode sortedArrayToBST(int[] nums) {
		 TreeNode root = binarySearch(nums,0,nums.length-1);
		 return root;
	 }

	private TreeNode binarySearch(int[] nums,int start,int end) {
		if(start>end) return null;
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = binarySearch(nums, start, mid-1);
		root.right = binarySearch(nums, mid+1, end);
		return root;
	}
}
