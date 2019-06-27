package com.wy.tree.bst;

/*
 * �ж��Ƿ�����Ч��BST
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class ValidBST98 {
	 
	//�����������Ȼ��Ƚϼ�����ǰ��ֵ�Ĵ�С��BST�����������һ���ǵ�������
	public boolean isValidBST2(TreeNode root) {
	        if(root==null)  return true;
	        TreeNode node = root;
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        List<Integer> list = new ArrayList<Integer>();
	        while(node!=null || !stack.isEmpty()) {
	        	if(node!=null) {
	        		stack.push(node);
	        		node = node.left;
	        	} else {
	        		TreeNode tmp = stack.pop();
	        		list.add(tmp.val);
	        		node = tmp.right;
	        		
	        	}
	        }
	        for(int i=0;i<list.size()-1;i++) {
	        	if(list.get(i)>=list.get(i+1)) {
	        		return false;
	        	}
	        }
	        return true;
	}
	 
	//ÿ�α�����ʱ���¼����ʱ�����ֵ����Сֵ
	 public boolean isValidBST3(TreeNode root) {
		 if(root==null) return true;
		 if(root.left==null&&root.right==null) return true;
		 return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
	 }

	private boolean helper(TreeNode root, long minValue, long maxValue) {
		if(root==null) return true;
		if(root.val<=minValue || root.val>=maxValue) return false;
		return helper(root.left,minValue,root.val) && helper(root.right,root.val,maxValue);
	}
	
	//������� ʹ��preָ��洢��һ�α����Ľڵ㣬Ȼ���뵱ǰ�ڵ���бȽ�
	public boolean isValidBST4(TreeNode root) {
		   if (root == null) return true;
		   Stack<TreeNode> stack = new Stack<>();
		   TreeNode pre = null;
		   while (root != null || !stack.isEmpty()) {
		      while (root != null) {
		         stack.push(root);
		         root = root.left;
		      }
		      root = stack.pop();
		      if(pre != null && root.val <= pre.val) return false;
		      pre = root;
		      root = root.right;
		   }
		   return true;
	}
	
	 public boolean isValidBST(TreeNode root){
			if(root==null) return true;
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode pre = null;
			TreeNode node = root;
			while(node!=null || !stack.isEmpty())  {
				if(node!=null) {
					stack.push(node);
					node=node.left;
				} else {
					TreeNode tmp = stack.pop();
					 if(pre != null && tmp.val <= pre.val) return false;
					pre =tmp;
					node = tmp.right;
				}
			}
			return true;
		}
}
