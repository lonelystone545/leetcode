package com.wy.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/*
 *  86. Partition List 
 *  Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x. 
	You should preserve the original relative order of the nodes in each of the two partitions. 
	For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5. 
 */
public class PartitionList {
	//这里使用队列实现
	public ListNode partition2(ListNode head, int x) {
        if(head==null) return null;
        Queue<Integer> queue = new LinkedList<Integer>();
        while(head!=null) {
        	queue.add(head.val);
        	head = head.next;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode fir = dummyNode;
        ListNode dummyNode2 = new ListNode(-1);
        ListNode sec = dummyNode2;
        while(!queue.isEmpty()) {
        	int tmp = queue.poll();
        	if(tmp<x) {
        		fir.next = new ListNode(tmp);
        		fir = fir.next;
        	} else {
        		sec.next = new ListNode(tmp);
        		sec = sec.next;
        	}
        }
        fir.next = dummyNode2.next;
        return dummyNode.next;
    }
	
	//不使用队列 空间O(1） 直接利用原先的链表
	public ListNode partition(ListNode head,int x) {
		if(head==null) return null;
		
		ListNode leftDummy = new ListNode(-1);
		ListNode rightDummy = new ListNode(-1);
		ListNode left = leftDummy,right = rightDummy;
		while(head!=null) {
			if(head.val<x) {
				left.next = head;
				left = head;
			} else {
				right.next = head;
				right = head;
			}
			head = head.next;
		}
		//结尾必须设为null
		right.next = null;
		//小的链表和大的链表进行连接
		left.next = rightDummy.next;
		return leftDummy.next;
	}
}
