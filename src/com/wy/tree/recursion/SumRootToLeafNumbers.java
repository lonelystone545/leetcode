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
   
   
   ������ʹ�õݹ飬ÿ�εݹ鶼���Եõ�һ����֧·��������Ȼ��洢��ȫ�ֱ���sum������ۼӡ�
   	   ��ǰ�ڵ��ʾ����=���ڵ��ֵ*10+��ǰ�ڵ�ֵ
 */
public class SumRootToLeafNumbers {
	//��Ϊȫ�ֱ���ʹ�ã�ֵ��һֱ���±��棬���ᶪʧ
	private int sum;
	public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        helper(root,0);
        return sum;
	}
	private void helper(TreeNode root, int num) {
		//num��ʾһ����֧�����ڵ㵽Ҷ�ڵ㣩·������ֵ
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
	
	//������
	public int sumNumbers2(TreeNode root) {
		return sum(root, 0);
	}

	public int sum(TreeNode n, int s){
		if (n == null) return 0;
		if (n.right == null && n.left == null) return s*10 + n.val;
		return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
	}
}
