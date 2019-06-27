package com.wy.linkedlist;

/*
 * 206. Reverse Linked List 
 * 单链表反转
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre = null;
        while(head!=null) {
        	//第一次完成的是第一个节点指向null操作
        	ListNode tmp = head.next;
        	head.next = pre;
        	pre = head;
        	head = tmp;
        }
        //退出循环时 head==null pre为原链表最后一个节点
        return pre;
    }
}
