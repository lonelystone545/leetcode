package com.wy.tree.bst;
/*
 *Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

	For example,
	Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   	由上题可知，可行的BST数是相应的卡特兰数，此题是求解所有的树，思路是采用递归。
   	每次选取一个节点作为根节点，然后递归求解左右子树的结果，最后根据左右子树返回的所有子树，依次选取然后链接即可。
 */
import java.util.ArrayList;
import java.util.List;

public class UniqueBST95 {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(n==0) return res;
		
        return helper(1,n); //从节点1开始到节点n，分别作为root节点
    }

	private List<TreeNode> helper(int start, int end) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(start>end) {
			res.add(null);
			return res;
		}
		
		//以i作为根节点
		for(int i=start;i<=end;i++) {
			List<TreeNode> left = helper(start,i-1); //左子树由start...i-1构成
			List<TreeNode> right = helper(i+1,end); //右子树由i+1....end构成
			//null也是可以遍历到的
			for(TreeNode l : left) {
				for(TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}
	
}
