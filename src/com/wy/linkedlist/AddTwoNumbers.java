package com.wy.linkedlist;

/*
 *  2. Add Two Numbers
 *  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	
	这样相加比较符合单链表的规律，只能从前往后遍历
 */
public class AddTwoNumbers {
	
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		int flag = 0;
		int val = 0;
		while(cur1!=null && cur2!=null) {
			//这里也适应于每个节点存储的数不是单数
			val = cur1.val;
			cur1.val = (cur1.val+cur2.val+flag)%10;
			flag = (val+cur2.val+flag)/10;
			
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		//两个都到达链尾
		if(cur1==null && cur2==null) {
			if(flag==1) {
				cur1 = new ListNode(flag);
			}
			return l1;
		}
		//其中一个到达链尾
		if(cur1!=null) {
			cur1.val = cur1.val + flag;
		}
		if(cur2!=null) {
			cur1 = cur2;
			cur1.val = cur1.val+flag;
		}
		return l1;
    }
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null && l2==null) return null;
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		//是否有进位
		int flag = 0;
		while(l1!=null && l2!=null) {
			cur.next = new ListNode((l1.val+l2.val+flag)%10);
			flag = (l1.val+l2.val+flag)/10;
			
			l1 = l1.next;
			l2 = l2.next;
			cur = cur.next;
		}
		
		
		//其中一个链表不为空
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
			cur = cur.next;
		}
		
		//链尾都为空
		if(flag != 0) {
			cur.next = new ListNode(flag);
		}
		return head.next;
	}
}
