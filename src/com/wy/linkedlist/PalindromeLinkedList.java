package com.wy.linkedlist;

import java.util.Stack;

/*
 * 234. Palindrome Linked List
 *  Given a singly linked list, determine if it is a palindrome.

	Follow up:
	Could you do it in O(n) time and O(1) space?
	
	˼·�� �ж�һ�������Ƿ��ǻ����������ֽⷨ����ʹ�õ���ָ�룬�������м�ָ�����
		  1 ��ǰ���ֵ�����Ԫ�ط��������У�Ȼ���ڱ�����벿�ֵ�����ʱ��������������Ԫ�ؽ��бȽ�
		  2 ��ǰ���ֵ�����Ԫ�ط���list�����У�ʹ��add(0,value)������ÿ�ζ��Ǵ�ͷ���룬Ȼ��Ƚ�
		  3 ���ö�ջ���Ƚ��������
		  4 ����벿������ԭ�ط�ת
		 
		 ֻ�е����ֵĿռ临�Ӷ���O(1)
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if(head==null) return true;
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode rhead = slow.next;
		slow.next = null;
		//�Ժ�벿������ת
		ListNode pre = null;
		while(rhead!=null) {
			ListNode tmp = rhead.next;
			rhead.next = pre;
			pre = rhead;
			rhead = tmp;
		}
		//��ʱpre�Ƿ�ת���ͷ�ڵ�
		while(head!=null && pre!=null) {
			if(head.val!=pre.val) {
				return false;
			}
			head = head.next;
			pre = pre.next;
		}
		return true;
	}
	
	//ʹ�ö�ջʵ��
	public boolean isPalindrome2(ListNode head) {
		if(head==null) return true;
		Stack<Integer> stack = new Stack<Integer>();
		ListNode slow=head,fast=head;
		//����һ��Ԫ�ؽ�ջ
		stack.push(slow.val);
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			//��ջ
			stack.push(slow.val);
		}
		
		//������Ҫ�������Ƚ����ж� ���Ϊ���������м��Ǹ��ڵ�ֵҲ��ջ�� ���Ϊż������Ƚ�Ӧ�ô���һ���ڵ㿪ʼ
		if(fast!=null) {
			slow = slow.next;
		}
		while(slow!=null) {
			if(slow.val!=stack.pop()) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
}
