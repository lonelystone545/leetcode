package com.wy.tree.traversal;
/*
 * Morris�㷨���������� 
 * ʹ�õ������������� 
 */
import java.util.ArrayList;
import java.util.List;

public class MorrisTreePrinter {
	
	//�������
	public List<Integer> morrisInOrder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null) return result; //����[]
		
		TreeNode cur = root;
		while(cur!=null) {
			if(cur.left==null) {
				result.add(cur.val);
				cur=cur.right;
			} else {
				TreeNode tmp = cur.left;
				while(tmp.right!=null && tmp.right!=cur) {
					tmp = tmp.right; //�ҵ������������ҽڵ�
				}
				if(tmp.right==null) {
					tmp.right=cur;
					cur=cur.left;
				} else {
					result.add(cur.val);
					tmp.right=null;
					cur=cur.right;
				}
			}
		}
		return result;
	}
	
	//ǰ�����
	public List<Integer> morrisPreOrder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null) return result; //����[]
		TreeNode cur = root;
		while(cur!=null) {
			if(cur.left==null) {
				result.add(cur.val); //�����ǰ�ڵ�
				cur=cur.right;
			} else {
				TreeNode tmp = cur.left;
				//�������������ҽڵ�
				while(tmp.right!=null && tmp.right!=cur) {
					tmp=tmp.right;
				}
				if(tmp.right==null){
					result.add(cur.val); //�����ǰ�ڵ�
					tmp.right = cur;
					cur=cur.left;
				} else {
					tmp.right=null; //�ָ�������
					cur=cur.right;
				}
			}
		}
		return result;
	}
	
	//�������
	public List<Integer> morrisPostOrder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null)  return result;
		TreeNode tmpNode = new TreeNode(-1); //����һ����ʱ�ڵ�
		tmpNode.left = root;//��ʱ�ڵ�����ӽڵ�ָ��root
		TreeNode cur = tmpNode;
		while(cur!=null) {
			if(cur.left==null) {
				cur = cur.right;
			} else {
				TreeNode tmp = cur.left;
				while(tmp.right!=null && tmp.right!=cur) 
					tmp = tmp.right;
				if(tmp.right==null) {
					tmp.right=cur;
					cur=cur.left;
				} else {
					tmp.right=null;
					TreeNode t = cur.left;
					List<Integer> tmpList = new ArrayList<>();
					while(t!=null) { //�������
						tmpList.add(0,t.val); //��ָ��λ���ϲ���Ԫ�أ������ƶ���λ����ԭ�ȵ�Ԫ�ؼ�����Ԫ��
						t = t.right;
					}
					result.addAll(tmpList);
					cur=cur.right;
				}
			}
		}
		return result;
	}
}
