package com.wy.tree.recursion;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. 
For example:
Given the below binary tree and sum = 22, 
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
	return
	[
   	  [5,4,11,2],
   	  [5,8,4,5]
	]
 */
public class PathSumII {
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<Integer>();
        if(root==null) return res;
        helper(root,res,cur,sum);
        return res;
    }

	private void helper(TreeNode root, List<List<Integer>> res, List<Integer> cur, int sum) {
		if(root==null) return;
		cur.add(root.val);
		if(root.left==null && root.right==null && root.val==sum) {
			//�������Ҫ���½���һ��list����
			//���ֱ��cur����ôcur�仯��ʱ��resҲ����ű仯��ֱ�Ӹ���֮ǰ�ģ�������[[]]
			List<Integer> newList = new ArrayList<>(cur);
			res.add(newList);
		}
		helper(root.left,res,cur,sum-root.val);
		helper(root.right,res,cur,sum-root.val);
		//ÿ�α��������һ��û�б������Ľڵ�ʱ����ȥ��
		cur.remove(cur.size()-1);
	}
}
