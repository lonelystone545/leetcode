package com.wy.linkedlist;

/*
 * 206. Reverse Linked List 
 * ������ת
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre = null;
        while(head!=null) {
        	//��һ����ɵ��ǵ�һ���ڵ�ָ��null����
        	ListNode tmp = head.next;
        	head.next = pre;
        	pre = head;
        	head = tmp;
        }
        //�˳�ѭ��ʱ head==null preΪԭ�������һ���ڵ�
        return pre;
    }
}
