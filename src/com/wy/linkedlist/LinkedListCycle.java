package com.wy.linkedlist;

/*
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.

	Follow up:
	Can you solve it without using extra space?
 */
public class LinkedListCycle {
	/*
	 * 思路：使用 两个指针slow和fast 看最后有没有相遇
	 * 如果使用额外的空间，可以使用哈希表记录每个元素出现的次数，看有没有重复即可
	 */
	public boolean hasCycle2(ListNode head) {
		if(head==null) return false;
		ListNode slow = head;
		ListNode fast = head;
		boolean flag = false;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public boolean hasCycle(ListNode head) {
		if(head==null || head.next == null) return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow!=fast) {
			if(fast==null || fast.next==null) {
				return false;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return true;
	}
}
