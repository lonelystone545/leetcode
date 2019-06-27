package com.wy.linkedlist;

/*
 * 82. Remove Duplicates from Sorted List II 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
	For example,
	Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3. 
 * 
 * 本质是三个指针，一个是记录重复数字之前的指针，一个是当前指针，一个是重复数字之后的指针
 */
public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates2(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while(cur!=null) {
        	while(cur.next!=null && cur.val==cur.next.val) {
        		cur = cur.next;
        	}
        	if(pre.next==cur) {
        		pre = pre.next;
        	} else {
        		pre.next = cur.next;
        	}
        	cur = cur.next;
        }
        return dummyNode.next;
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		head = dummyNode;
		while(head.next!=null && head.next.next!=null) {
			if(head.next.val==head.next.next.val) {
				int val = head.next.val;
				while(head.next!=null && head.next.val==val) {
					head.next = head.next.next;
				}
			} else {
				head = head.next;
			}
		}
		return dummyNode.next;
	}
}
