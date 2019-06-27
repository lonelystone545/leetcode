package com.wy.tree.construct.copy;
/*
 * 根据前序遍历和中序遍历构建二叉树
 * 时间复杂度O(n) 空间O(logn)
 */
public class BuildTree105 {
	public static TreeNode buildTree2(int[] preorder, int[] inorder) {
		if(preorder.length<1 || inorder.length<1) {
			return null;
		}
		int rootIndex = 0;
        for(int i=0;i<inorder.length;i++) {
        	if(inorder[i]==preorder[0]) {
        		rootIndex = i;
        		break;
        	}
        }
        int[] inorderLeft = new int[rootIndex];
        int[] inorderRight = new int[inorder.length-1-rootIndex];
        int[] preorderLeft = new int[rootIndex];
        int[] preorderRight=new int[preorder.length-1-rootIndex];
        
        for(int i=0;i<rootIndex;i++) {
        	inorderLeft[i] = inorder[i];
        }
        for(int i=rootIndex+1;i<inorder.length;i++) {
        	inorderRight[i-rootIndex-1]=inorder[i];
        }
        for(int i=1;i<rootIndex+1;i++) {
        	preorderLeft[i-1] = preorder[i];
        }
        for(int i=rootIndex+1;i<preorder.length;i++) {
        	preorderRight[i-rootIndex-1] = preorder[i];
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        root.left=buildTree(preorderLeft,inorderLeft);
        root.right = buildTree(preorderRight,inorderRight);
        return root;
    }
	
	
	
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		int preLength = preorder.length;
		int inLength = inorder.length;
		return helper(preorder,0,preLength-1,inorder,0,inLength-1);
	}
	
	private static TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if(inStart>inEnd || preStart>preEnd) {
			return null;
		}
		int rootVal = preorder[preStart];
		int rootIndex = 0;
		for(int i=0;i<=inEnd;i++) {
			if(inorder[i] == rootVal) {
				rootIndex = i;
				break;
			}
		}
		
		int len = rootIndex-inStart;
		TreeNode root = new TreeNode(rootVal);
		root.left = helper(preorder,preStart+1,preStart+len,inorder,inStart,rootIndex-1);
		root.right = helper(preorder,preStart+len+1,preEnd,inorder,rootIndex+1,inEnd);
		return root;
	}

	public static void main(String[] args) {
		int[] preorder = {1,2,4,5,3,6,7 };
		int[] inorder = {4,2,5,1,6,3,7};
		TreeNode root = buildTree(preorder,inorder);
		System.out.println(root.val);
	}
}
