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
       //指向交换过节点对的前一个节点
       ListNode pre = dummyNode;
       dummyNode.next = head;
       //指向要交换节点对的第一个节点
       ListNode cur = head;
       //节点数可能是奇数或者偶数 作为判断终止条件
       //每次以pre cur 和 cur.next作为一组，进行不断的节点对交换
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
