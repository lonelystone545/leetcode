package com.wy.tree.recursion;

/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
   An example is the root-to-leaf path 1->2->3 which represents the number 123.
   Find the total sum of all root-to-leaf numbers.
   For example, 
      1
     / \
    2   3

   The root-to-leaf path 1->2 represents the number 12.
   The root-to-leaf path 1->3 represents the number 13. 
   Return the sum = 12 + 13 = 25. 
   
   
   解析：使用递归，每次递归都可以得到一条分支路径的数，然后存储到全局变量sum里进行累加。
   	   当前节点表示的数=父节点的值*10+当前节点值
 */
public class SumRootToLeafNumbers {
	//作为全局变量使用，值会一直更新保存，不会丢失
	private int sum;
	public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        helper(root,0);
        return sum;
	}
	private void helper(TreeNode root, int num) {
		//num表示一条分支（根节点到叶节点）路径的数值
		num = 10*num + root.val;
		if(root.left==null && root.right==null) {
			sum = sum + num;
		}
		if(root.left!=null) {
			helper(root.left,num);
		}
		if(root.right!=null) {
			helper(root.right,num);
		}
	}
	
	//方法二
	public int sumNumbers2(TreeNode root) {
		return sum(root, 0);
	}

	public int sum(TreeNode n, int s){
		if (n == null) return 0;
		if (n.right == null && n.left == null) return s*10 + n.val;
		return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
	}
}
