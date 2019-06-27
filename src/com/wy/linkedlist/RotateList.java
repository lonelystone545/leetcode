package com.wy.linkedlist;

/*
 *  61. Rotate List 
 *  Given a list, rotate the list to the right by k places, where k is non-negative.
	For example:
	Given 1->2->3->4->5->NULL and k = 2,
	return 4->5->1->2->3->NULL.
 * 
 * ע�⣺k���Դ�������ĳ��ȣ���Ҫ��������ȡ��
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k<1) return head;
        int count = 1;
        ListNode cur = head;
        ListNode tail = null;
        while(cur.next!=null) {
        	cur = cur.next;
        	count++;
        }
        //��ʱcurָ�����һ���ڵ�
        tail = cur;
        //k���Դ���������
        k = k%count;
        if(k==0) return head;
        int tmp = count - k;
        //cur����ָ��ͷ�ڵ�
        cur = head;
        while((--tmp)!=0) {
        	cur =cur.next;
        }
        //��ʱcurָ��Ҫ��ת�ڵ��ǰһ���ڵ�
        tail.next = head;
        //��head���¸�ֵ
        head = cur.next;
        cur.next = null;
        return head;
    }
}
