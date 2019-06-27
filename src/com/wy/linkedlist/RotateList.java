package com.wy.linkedlist;

/*
 *  61. Rotate List 
 *  Given a list, rotate the list to the right by k places, where k is non-negative.
	For example:
	Given 1->2->3->4->5->NULL and k = 2,
	return 4->5->1->2->3->NULL.
 * 
 * 注意：k可以大于链表的长度，需要对链表长度取余
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k<1) return head;
        int count = 1;
        ListNode cur = head;
        ListNode tail = null;
        while(cur.next!=null) {
        	cur = cur.next;
        	count++;
        }
        //此时cur指向最后一个节点
        tail = cur;
        //k可以大于链表长度
        k = k%count;
        if(k==0) return head;
        int tmp = count - k;
        //cur重新指向头节点
        cur = head;
        while((--tmp)!=0) {
        	cur =cur.next;
        }
        //此时cur指向要翻转节点的前一个节点
        tail.next = head;
        //对head重新赋值
        head = cur.next;
        cur.next = null;
        return head;
    }
}
