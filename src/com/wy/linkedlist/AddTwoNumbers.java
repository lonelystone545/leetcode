package com.wy.linkedlist;

/*
 *  2. Add Two Numbers
 *  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	
	������ӱȽϷ��ϵ�����Ĺ��ɣ�ֻ�ܴ�ǰ�������
 */
public class AddTwoNumbers {
	
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		int flag = 0;
		int val = 0;
		while(cur1!=null && cur2!=null) {
			//����Ҳ��Ӧ��ÿ���ڵ�洢�������ǵ���
			val = cur1.val;
			cur1.val = (cur1.val+cur2.val+flag)%10;
			flag = (val+cur2.val+flag)/10;
			
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		//������������β
		if(cur1==null && cur2==null) {
			if(flag==1) {
				cur1 = new ListNode(flag);
			}
			return l1;
		}
		//����һ��������β
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
		//�Ƿ��н�λ
		int flag = 0;
		while(l1!=null && l2!=null) {
			cur.next = new ListNode((l1.val+l2.val+flag)%10);
			flag = (l1.val+l2.val+flag)/10;
			
			l1 = l1.next;
			l2 = l2.next;
			cur = cur.next;
		}
		
		
		//����һ������Ϊ��
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
		
		//��β��Ϊ��
		if(flag != 0) {
			cur.next = new ListNode(flag);
		}
		return head.next;
	}
}
