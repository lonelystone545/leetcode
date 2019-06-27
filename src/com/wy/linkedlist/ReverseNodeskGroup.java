package com.wy.linkedlist;

/*
 * 25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodeskGroup {
	
	//递归实现
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while(curr!=null && count!=k) {
			curr = curr.next;
			count++;
		}
		//找到curr为k+1节点
		if(count==k) {
			//以curr作为头节点
			curr = reverseKGroup(curr, k);
			while(count-- >0) {
				ListNode tmp = head.next;
				head.next = curr;
				curr = head;
				head = tmp;
			}
			//curr此时为翻转后的第一个节点
			head = curr;
		}
		return head;
	}
	
	//非递归实现
	public ListNode reverseKGroup2(ListNode head, int k) {
		if(head==null || k==1) return head;
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode pre = dummyNode;
		ListNode cur = head;
		int count = 0;
		while(cur!=null) {
			count++;
			//保存下一组的第一个节点
			ListNode next = cur.next;
			if(count==k) {
				//将变换之后的最后一个节点也就是变换之前的第一个节点赋值给pre
				pre = reverse(pre,next);
				count=0;
			}
			//这里cur.next已经发生变化了，不能cur = cur.next
			cur = next;
		}
		return dummyNode.next;
	}

	private ListNode reverse(ListNode pre, ListNode next) {
		//需要改变pre指针，使之最后指向该组的最后一个节点
		//最后返回的是last指针，该组的第一个节点
		ListNode last = pre.next;
		ListNode curr = last.next;
		while(curr!=next) {
			last.next = curr.next;
			curr.next = pre.next;
			pre.next = curr;
			curr = last.next;
		}
		return last;
	}
}
