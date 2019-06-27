package com.wy.linkedlist;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
       if(head==null) return null;
       ListNode dummyNode = new ListNode(-1);
       //ָ�򽻻����ڵ�Ե�ǰһ���ڵ�
       ListNode pre = dummyNode;
       dummyNode.next = head;
       //ָ��Ҫ�����ڵ�Եĵ�һ���ڵ�
       ListNode cur = head;
       //�ڵ�����������������ż�� ��Ϊ�ж���ֹ����
       //ÿ����pre cur �� cur.next��Ϊһ�飬���в��ϵĽڵ�Խ���
       while(cur!=null && cur.next!=null) {
    	   ListNode next = cur.next;
    	   cur.next = next.next;
    	   next.next = cur;
    	   pre.next = next;
    	   
    	   cur = cur.next;
    	   pre = pre.next.next;
       }
       return dummyNode.next;
	}
	
	public ListNode swapPairs2(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode node = head.next;
		head.next = swapPairs(head.next.next);
		node.next = head;
		return node;
	}
	       
}
