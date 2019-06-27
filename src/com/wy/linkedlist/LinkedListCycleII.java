package com.wy.linkedlist;

/*
 * 142. Linked List Cycle II
 * 
 *  Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

	Note: Do not modify the linked list.
	
	
	当fast和slow相遇时，slow肯定没有遍历完链表，而fast已经在环内循环了n圈。假设slow走了s步，则fast走了2s步，
	环长为r，则有2s = s+nr;   s = nr。设整个链表长L，环入口点与相遇点距离为a，起点到环入口点距离为x，则
	x+a=nr=(n-1)r+r=(n-1)r+L-x    x=(n-1)r+(L-x-a)
	L-x-a为相遇点到入口点距离。可知，由链表头到环入口点等于n-1圈内环+相遇点到环入口点，于是可以从head开始另
	设置一个指针slow2，两个慢指针每次前进一步，它俩一定会在环入口点相遇。
 */
public class LinkedListCycleII {
	/*
	 * 双指针法：fast和slow第一次相遇时，此时再让一个slow2从head出发，slow继续走，当下次slow2和slow相遇时即为入口点。
	 */
	public ListNode detectCycle(ListNode head) {
		if(head==null || head.next==null) return null;
		ListNode slow = head;
		ListNode fast = head;
		boolean flag = false;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) {
				flag = true;
				break;
			}
		}
		if(flag){
			ListNode slow2 = head;
			while(slow!=slow2) {
				slow = slow.next;
				slow2 = slow2.next;
			}
		} else {
			return null;
		}
		return slow;
    }
}
