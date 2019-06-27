package com.wy.linkedlist;

/*
 * 83. Remove Duplicates from Sorted List 	
 * Given a sorted linked list, delete all duplicates such that each element appear only once. 
	For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3. 
 */
public class RemoveDuplicatesfromSortedList {
	//迭代实现
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode node = head;
        while(node.next!=null) {
        	if(node.val==node.next.val) {
        		node.next = node.next.next;
        	} else {
        		node = node.next;
        	}
        }
        return head;
	}
	//递归实现
	public ListNode deleteDuplicates2(ListNode head) {
		if(head==null || head.next==null) return head;
		head.next = deleteDuplicates2(head.next);
		if(head.val==head.next.val) {
			return head.next;
		} else {
			return head;
		}
	}
}
