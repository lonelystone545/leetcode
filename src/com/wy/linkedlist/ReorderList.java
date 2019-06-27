package com.wy.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 143. Reorder List
 * Given a singly linked list L: L0��L1������Ln-1��Ln,
	reorder it to: L0��Ln��L1��Ln-1��L2��Ln-2����
	
	You must do this in-place without altering the nodes' values.
	
	For example,
	Given {1,2,3,4}, reorder it to {1,4,2,3}
 */
public class ReorderList {
	/*
	  ˼·�� 1 ������ָ���ҵ��м�ڵ㣬�������Ϊ��������
	  	   2 �Ժ�벿�ֵ������������
	  	   3 �ϲ���������	
	 */
	public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        //��ʱslow���м�Ľڵ�
        ListNode rhead = slow.next;
        slow.next = null;
        rhead = reverse(rhead);
        
        //�ϲ�����
        while(head!=null && rhead!=null) {
        	ListNode tmp1 = head.next;
        	ListNode tmp2 = rhead.next;
        	head.next = rhead;
        	rhead.next = tmp1;
        	
        	head = tmp1;
        	rhead = tmp2;
        }
    }
	
	//��ת
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
	
	public void reorderList2(ListNode head) {
		if(head==null || head.next==null) return;
		//˫�˶��� ���������˽��в���
		Deque<ListNode> deque = new LinkedList<>();
		ListNode cur = head;
		while(cur!=null) {
			deque.addLast(cur);
			cur = cur.next;
		}
		
		ListNode result = new ListNode(-1);
		while(!deque.isEmpty()) {
			result.next = deque.pollFirst();
			result = result.next;
			if(!deque.isEmpty()) {
				result.next = deque.pollLast();
				result = result.next;
			}
			
		}
		result.next=null;
	}
}
