package com.wy.tree.traversal;
/*
 *       1
        / \
       2   5
      / \   \
     3   4   6
     
     
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
import java.util.Stack;

public class FlattenTree {
	//使用栈实现
	public void flatten(TreeNode root) {
//		if(root==null)  return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while(node!=null || !stack.isEmpty()) {
			if(node.right!=null) {
				stack.push(node.right);
			}
			if(node.left!=null) {
				node.right=node.left;
				node.left=null;
			} else if(!stack.isEmpty()){
				TreeNode tmp = stack.pop();
				node.right=tmp;
			}
			node = node.right;
		}
	}
	
	//前序遍历二叉树，遇到左子节点时，将其变为右子节点，并将左置空
	//因此需要一个全局变量存储之前的右子节点
	private TreeNode lastNode = null;
	public void flatten2(TreeNode root) {
		if(root==null) return;
		if(lastNode !=null) {
			lastNode.left = null;
			lastNode.right = root;
		}
		
		lastNode = root;
		TreeNode right = root.right;
		flatten2(root.left);
		flatten2(right);
	}
}
