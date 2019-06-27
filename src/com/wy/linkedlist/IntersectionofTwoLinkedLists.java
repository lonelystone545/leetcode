package com.wy.linkedlist;

/*
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * ������ж����������Ƿ��ཻ��������hash���߱�������󿴽ڵ���Ȳ���
 */
public class IntersectionofTwoLinkedLists {
	
	/*
	 * ͳ����������ĳ��ȣ�Ȼ��ʹ����ָ�룬�ó������ָ������lenA-lenB����Ȼ����һ����
	 */
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        //����������len1-len2��
        while(lenA>lenB) {
        	headA = headA.next;
        	lenA--;
        }
        while(lenA<lenB) {
        	headB = headB.next;
        	lenB--;
        }
        //ͬʱ����
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
	//һ�����������β��ʱ��������һ�������ͷ����ʼ�ٴα��������ջ�����
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
