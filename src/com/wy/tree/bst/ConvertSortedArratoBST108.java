package com.wy.tree.bst;

/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * ע��ݹ���˳�
 * 
 * �����������Binary Search Tree����Ҳ�������������ordered binary tree��,�����������sorted binary tree������ָһ�ÿ������߾����������ʵĶ�������

	������ڵ�����������գ��������������н���ֵ��С�����ĸ�����ֵ��
	����ڵ�����������գ��������������н���ֵ���������ĸ�����ֵ��
	����ڵ����������Ҳ�ֱ�Ϊ�����������
	
	ƽ���������������ƽ��ģ����ڷǿյ�����˵������������ƽ��ģ���������ƽ��ģ������������ĸ߶Ȳ����1.
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
