package com.wy.tree.bst;

/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * ����һ�������������Ԫ�����������С�
 * ��ͨ�ⷨ�ǰѵ�����ת�������飬Ȼ���������ⷨ�����ﲻ������ˡ�
 */
public class ConvertSortedListtoBST109 {
	
	//����һ������ָ�룬��ָ��ÿ����������ָ��ÿ��һ����������ָ�뵽ͷ��ʱ����ָ�����õ��м�
	 public TreeNode sortedListToBST2(ListNode head) {
		 	if(head==null) return null;
		 	return helper(head,null);
	    }

	private TreeNode helper(ListNode head, ListNode target) {
		if(head == target) return null;
		ListNode fast = head;
        ListNode slow = head;
        while(fast!=target && fast.next!=target) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        //��ʱslow�����м�λ��
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head,slow);
        root.right = helper(slow.next,target);
		return root;
	}
	
	
	//����һ��ȫ�ֱ���
	ListNode curr;
	//�Ե����Ͻ���BST
	public TreeNode sortedListToBST(ListNode head) {
		curr = head;
		int len = 0;
		//��������ĳ���
		while(head!=null) {
			head = head.next;
			len++;
		}
		//����
		return buildTree(0,len-1);
	}

	private TreeNode buildTree(int start, int end) {
		//û���ӽڵ㣬ֱ�ӷ���
		if(start>end) return null;
		int mid = start+(end-start)/2; //��ֹ���
		TreeNode left = buildTree(start, mid-1);
		TreeNode root = new TreeNode(curr.val);
		//����˳�����
		curr = curr.next;
		TreeNode right = buildTree(mid+1, end);
		//���ڵ���������
		root.left = left;
		root.right = right;
		return root;
	}
}
