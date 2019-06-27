package com.wy.linkedlist;

import java.util.Stack;

/*
 * 445. Add Two Numbers II 
 *  You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	单链表只能从前往后遍历，可以先进行反转或者直接使用栈实现。
 */
public class AddTwoNumbersII {
	
	//使用栈实现
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		while(l1!=null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		while(l2!=null) {
			s2.push(l2.val);
			l2 = l2.next;
		}
		
		ListNode head = new ListNode(-1);
		int flag = 0;
		while(!s1.isEmpty() || !s2.isEmpty()) {
			if(!s1.isEmpty()) {
				flag += s1.pop();
			}
			if(!s2.isEmpty()) {
				flag += s2.pop();
			}
			head.val = flag%10;
			ListNode pre = new ListNode(flag/10);
			pre.next = head;
			head = pre;
			flag /= 10;
		}
		return head.val==0? head.next:head;
	}
	
	//先翻转，然后再去相加
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        return reverse(addLists(l1,l2));
        
    }

	//两个链表相加
	private ListNode addLists(ListNode l1, ListNode l2) {
		
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		int flag = 0;
		while(l1!=null && l2 !=null) {
			cur.next = new ListNode((l1.val+l2.val+flag)%10);
			flag = (l1.val+l2.val+flag)/10;
			
			l1 = l1.next;
			l2 = l2.next;
			cur = cur.next;
		}
		
		while(l1!=null) {
			cur.next = new ListNode((l1.val+flag)%10);
			flag = (l1.val+flag)/10;
			l1 = l1.next;
			cur = cur.next;
		}
		while(l2!=null) {
			cur.next = new ListNode((l2.val+flag)%10);
			flag = (l2.val+flag)/10;
			l2 = l2.next;
			cur =cur.next;
		}
		while(flag!=0) {
			cur.next = new ListNode(flag%10);
			flag = flag/10;
			cur = cur.next;
		}
		return head.next;
	}

	//链表反转
	private ListNode reverse(ListNode head) {
		ListNode pre = null;
		while(head!=null) {
			ListNode tmp = head.next;
			head.next = pre;
			pre = head;
			head = tmp;
		}
		return pre;
	}
}
