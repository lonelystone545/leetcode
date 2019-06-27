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
	//ʹ��ջʵ��
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
	
	//ǰ��������������������ӽڵ�ʱ�������Ϊ���ӽڵ㣬�������ÿ�
	//�����Ҫһ��ȫ�ֱ����洢֮ǰ�����ӽڵ�
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
