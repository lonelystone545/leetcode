package com.wy.linkedlist;


/*
 *  Given a linked list, remove the nth node from the end of list and return its head.
	For example,
    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:
	Given n will always be valid.
	Try to do this in one pass.
	
	ע�⣺1 ������Ŀ������ʹ��fast��slowָ���������fast����ǰ��n����Ȼ��slow��fast��һ���ߡ���fastΪnullʱ��slow����Ҫɾ���Ľڵ㡣
		 2 Ҫɾ���Ľڵ������ͷ�ڵ㣬��Ҫ�����ж�һ�£���������һ��dummyNode��ָ��head��������ʹhead�ڵ�������ڵ�һ���ˡ�
	
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        
        //ά��һ��dummyNode 
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
        //��ʱ��cur��Ҫɾ���ڵ��ǰ��һ���ڵ�
        cur.next = cur.next.next;
        return dummyNode.next;
    }
	
	/*
	 * ������Ŀ����ʹ������ָ��fast slow��һ��ʼfast��ǰ��n����Ȼ��fast��slow��һ���ߡ���fastΪnullʱ��slowָ����Ҫɾ���Ľڵ�
	 * ɾ��һ���ڵ�ʱ����Ҫһ��ָ��preָ��Ҫɾ���ڵ��ǰ��һ���ڵ㣬������fast.next==null����ʱslowָ��Ҫɾ���ڵ��ǰһ���ڵ㣬�Ͳ���Ҫһ��preָ����
	 */
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		if(head==null) return null;
		ListNode fast = head;
		ListNode slow = head;
		//fast��ǰ��n��
		while((n--)!=0) {
			fast = fast.next;
		}
		//fastΪnull ��ʾҪɾ������ͷ�ڵ�
		if(fast==null) {
			return head.next;
		}
		//fast slowһ���� slow�൱������l-n��
		while(fast.next!=null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
		return head;
	}
}
