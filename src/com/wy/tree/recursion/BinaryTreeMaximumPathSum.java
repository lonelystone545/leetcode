package com.wy.tree.recursion;
/*
 * Given a binary tree, find the maximum path sum. 
   For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
   For example:
   Given the below binary tree, 
       1
      / \
     2   3

  Return 6. 
  
 在二叉树中求任意一个节点到另外一个节点路径和的最大值（可以不经过根节点）
 
 注意：1 要考虑到节点值为负数的情况
 	  2 使用递归，下层向上层返回值有三种情况（只能选择一条分支）：自身节点的值  自身节点的值+左子节点的值  自身节点的值+右子节点的值
 	  3 在每次遍历时，要把最大值记录并更新到一个全局变量或者数组中。max为自身节点+左子节点+右子节点的值和返回值中的较大者
 */
public class BinaryTreeMaximumPathSum {
	
	//时间O(n)  空间O(logn)深度
	public int maxPathSum(TreeNode root) {
		if(root ==null) return 0;
		int[] max = new int[1];
		//用来记录每次递归后的最大值
		//使用引用类型，这样层层递归之后，值是可以一直保存的，也可以使用成员变量作为全局变量使用
		max[0] = Integer.MIN_VALUE;
		helper(root,max);
		return max[0];
	}

	private int helper(TreeNode root, int[] max) {
		if(root==null) return 0;
		
		int left = helper(root.left,max);
		int right = helper(root.right,max);
		
		//作为向父节点的返回值（只能选一条分支），三种情况：1本身节点的值最大 2左子节点+本身节点值最大 3右子节点+本身节点值最大
		int res = Math.max(root.val, Math.max(left+root.val, right+root.val));
		//更新max数组的值，此时需要和left+right+root.val比较，取最大
		max[0] = Math.max(Math.max(res, left+right+root.val), max[0]);
		return res;
	}
}
