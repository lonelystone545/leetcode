package com.wy.linkedlist;

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass. 
	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4, 
	return 1->4->3->2->5->NULL. 
	Note:
	Given m, n satisfy the following condition:
	1 ≤ m ≤ n ≤ length of list. 
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
    
		if(head==null || m>n) {
			return null;
		}
		
		//设置一个dummyNode 便于操作
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		head = dummyNode;
		//到m-n区间前面一个节点
		for(int i=1;i<m;i++) {
			if(head==null) {
				return null;
			}
			head = head.next;
		}
		
		//保存n-m区间前一个节点
		ListNode pre = head;
		//保存n-m区间第一个节点
		ListNode fNode = head.next;
		ListNode lastNode = null;
		ListNode curNode= fNode;
		for(int i=m;i<=n;i++) {
			ListNode tmp = curNode.next;
			curNode.next = lastNode;
			lastNode = curNode;
			curNode = tmp;
		}
		pre.next = lastNode;
		fNode.next = curNode;
		
		return dummyNode.next;
	}
}
