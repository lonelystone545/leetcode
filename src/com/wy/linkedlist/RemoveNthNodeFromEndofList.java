package com.wy.linkedlist;


/*
 *  Given a linked list, remove the nth node from the end of list and return its head.
	For example,
    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:
	Given n will always be valid.
	Try to do this in one pass.
	
	注意：1 这种题目都可以使用fast和slow指针来解决。fast先向前走n步，然后slow和fast再一起走。当fast为null时，slow就是要删除的节点。
		 2 要删除的节点可能是头节点，需要单独判断一下，或者设置一个dummyNode，指向head，这样就使head节点和其他节点一样了。
	
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        
        //维护一个dummyNode 
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = head;
        int length = 0;
        while(cur!=null) {
        	cur = cur.next;
        	length++;
        }
        
        if(n>length) return head;
        int tmp = length - n;
        cur = dummyNode;
        while((tmp--)!=0) {
        	cur = cur.next;
        }
        //此时的cur是要删除节点的前面一个节点
        cur.next = cur.next.next;
        return dummyNode.next;
    }
	
	/*
	 * 这种题目可以使用两个指针fast slow，一开始fast向前走n步，然后fast和slow再一起走。当fast为null时，slow指向了要删除的节点
	 * 删除一个节点时，需要一个指针pre指向要删除节点的前面一个节点，这里另fast.next==null，此时slow指向要删除节点的前一个节点，就不需要一个pre指针了
	 */
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		if(head==null) return null;
		ListNode fast = head;
		ListNode slow = head;
		//fast向前走n步
		while((n--)!=0) {
			fast = fast.next;
		}
		//fast为null 表示要删除的是头节点
		if(fast==null) {
			return head.next;
		}
		//fast slow一起走 slow相当于走了l-n步
		while(fast.next!=null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
		return head;
	}
}
