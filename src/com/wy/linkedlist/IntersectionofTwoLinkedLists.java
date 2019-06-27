package com.wy.linkedlist;

/*
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * 如果是判断两个链表是否相交，可以用hash或者遍历到最后看节点相等不。
 */
public class IntersectionofTwoLinkedLists {
	
	/*
	 * 统计两个链表的长度，然后使用俩指针，让长链表的指针先走lenA-lenB步，然后再一起走
	 */
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        //长链表先走len1-len2步
        while(lenA>lenB) {
        	headA = headA.next;
        	lenA--;
        }
        while(lenA<lenB) {
        	headB = headB.next;
        	lenB--;
        }
        //同时遍历
        while(headA!=headB) {
        	headA = headA.next;
        	headB = headB.next;
        }
        return headA;
	}

	private int getLength(ListNode head) {
		int len = 0;
		while(head!=null) {
			head = head.next;
			len++;
		}
		return len;
	}
	//一个链表遍历到尾部时，从另外一个链表的头部开始再次遍历，最终会相遇
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null || headB==null) return null;
		ListNode curA = headA;
		ListNode curB = headB;
		while(curA!=curB) {
			curA = curA==null? headB:curA.next;
			curB = curB==null? headA:curB.next;
		}
		return curA;
	}
}
