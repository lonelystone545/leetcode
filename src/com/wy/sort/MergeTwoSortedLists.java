package com.wy.sort;

public class MergeTwoSortedLists {
//	 public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
//	        ListNode node1 = new ListNode(0);
//	        ListNode start = node1;
//	        if(l1==null && l2==null) return null;
//	        while(l1!=null && l2!=null) {
//	        	if(l1.val<l2.val) {
//	        		node1.val = l1.val;
//	        		l1 = l1.next;
//	        		node1 = node1.next;
//	        	} else {
//	        		node1.val = l2.val;
//	        		l2 = l2.next;
//	        		node1 = node1.next;
//	        	}
//	        }
//	        while(l1!=null) { //此时l2==null
//	        	node1.val = l1.val;
//	        	node1 = node1.next;
//	        	l1 = l1.next;
//	        }
//	        
//	        while(l2!=null) { //此时l1==null
//	        	node1.val = l2.val;
//	        	node1 = node1.next;
//	        	l2 = l2.next;
//	        }
//	        return start;
//	 }
	 
	//递归解法
	 public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		 if(l1==null) return l2;
		 if(l2==null) return l1;
		 ListNode head;
		 if(l1.val<l2.val) {
			 head = l1;
			 head.next = mergeTwoLists(l1.next, l2);
		 } else {
			 head = l2;
			 head.next = mergeTwoLists(l1, l2.next);
		 }
		 return head;
	 }
	 
	 //非递归
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 //头节点
		 ListNode head = new ListNode(-1);
		 //进行指针移动
		 ListNode p = head;
		 while(l1!=null && l2!=null) {
			 if(l1.val<l2.val) {
				 p.next=l1;
				 l1=l1.next;
			 } else {
				 p.next=l2;
				 l2=l2.next;
			 }
			 p=p.next;
		 }
		 if(l1!=null){
			 p.next=l1;
		 }
		 if(l2!=null) {
			 p.next=l2;
		 }
		 return head.next;
	 }
}
