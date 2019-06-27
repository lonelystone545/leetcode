package com.wy.linkedlist;

import java.util.Stack;

/*
 * 234. Palindrome Linked List
 *  Given a singly linked list, determine if it is a palindrome.

	Follow up:
	Could you do it in O(n) time and O(1) space?
	
	思路： 判断一个链表是否是回文链表，几种解法都会使用到俩指针，用来从中间分割链表。
		  1 将前部分的链表元素放入数组中，然后在遍历后半部分的链表时，和数据中逆序元素进行比较
		  2 将前部分的链表元素放在list集合中，使用add(0,value)方法，每次都是从头插入，然后比较
		  3 利用堆栈的先进后出特性
		  4 将后半部分链表原地翻转
		 
		 只有第四种的空间复杂度是O(1)
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
		//对后半部分链表翻转
		ListNode pre = null;
		while(rhead!=null) {
			ListNode tmp = rhead.next;
			rhead.next = pre;
			pre = rhead;
			rhead = tmp;
		}
		//此时pre是翻转后的头节点
		while(head!=null && pre!=null) {
			if(head.val!=pre.val) {
				return false;
			}
			head = head.next;
			pre = pre.next;
		}
		return true;
	}
	
	//使用堆栈实现
	public boolean isPalindrome2(ListNode head) {
		if(head==null) return true;
		Stack<Integer> stack = new Stack<Integer>();
		ListNode slow=head,fast=head;
		//将第一个元素进栈
		stack.push(slow.val);
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			//入栈
			stack.push(slow.val);
		}
		
		//这里需要对链表长度进行判断 如果为奇数，则中间那个节点值也进栈了 如果为偶数，则比较应该从下一个节点开始
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
