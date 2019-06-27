package com.wy.linkedlist;

/*
 * 25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodeskGroup {
	
	//�ݹ�ʵ��
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while(curr!=null && count!=k) {
			curr = curr.next;
			count++;
		}
		//�ҵ�currΪk+1�ڵ�
		if(count==k) {
			//��curr��Ϊͷ�ڵ�
			curr = reverseKGroup(curr, k);
			while(count-- >0) {
				ListNode tmp = head.next;
				head.next = curr;
				curr = head;
				head = tmp;
			}
			//curr��ʱΪ��ת��ĵ�һ���ڵ�
			head = curr;
		}
		return head;
	}
	
	//�ǵݹ�ʵ��
	public ListNode reverseKGroup2(ListNode head, int k) {
		if(head==null || k==1) return head;
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode pre = dummyNode;
		ListNode cur = head;
		int count = 0;
		while(cur!=null) {
			count++;
			//������һ��ĵ�һ���ڵ�
			ListNode next = cur.next;
			if(count==k) {
				//���任֮������һ���ڵ�Ҳ���Ǳ任֮ǰ�ĵ�һ���ڵ㸳ֵ��pre
				pre = reverse(pre,next);
				count=0;
			}
			//����cur.next�Ѿ������仯�ˣ�����cur = cur.next
			cur = next;
		}
		return dummyNode.next;
	}

	private ListNode reverse(ListNode pre, ListNode next) {
		//��Ҫ�ı�preָ�룬ʹ֮���ָ���������һ���ڵ�
		//��󷵻ص���lastָ�룬����ĵ�һ���ڵ�
		ListNode last = pre.next;
		ListNode curr = last.next;
		while(curr!=next) {
			last.next = curr.next;
			curr.next = pre.next;
			pre.next = curr;
			curr = last.next;
		}
		return last;
	}
}
