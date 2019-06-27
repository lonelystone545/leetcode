package com.wy.list;

public class RemoveLinkedListElements {
	
	//设置一个dummyNode，指向头节点
	public ListNode removeElements2(ListNode head, int val) {
		
        if(head==null) return null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while(cur.next!=null) {
        	if(cur.next.val==val) {
        		cur.next = cur.next.next;
        	} else {
        		cur = cur.next;
        	}
        }
        return dummyNode.next;
    }
	
	//最后对头节点进行判断
	public ListNode removeElements3(ListNode head,int val) {
		if(head==null) return null;
		ListNode cur = head;
		while(cur.next!=null) {
			if(cur.next.val==val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head.val==val?head.next:head;
	}
	
	//使用递归
	public ListNode removeElements(ListNode head,int val){
		if(head==null) return null;
		head.next = removeElements(head.next, val);
		return head.val!=val? head:head.next;
	}
}
