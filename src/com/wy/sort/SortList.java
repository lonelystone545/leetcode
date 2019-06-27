package com.wy.sort;

/*
 * Sort List 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * O(nlogn)�������㷨�й鲢�����źͶ����򡣿�������˫������Ƚ϶࣬���������ʺ��ù鲢����
 * 
 * �ؼ����ҵ��м�ڵ㣬��������˿���ָ�룬����ָ�������������ָ�����ڵ�λ�þ����м�λ�á�
 * Ȼ������ָ�����һ���ڵ���Ϊ�µ�ͷ������������нضϣ�������һ������ͱ��ָ������������
 * ���ںϲ���������֮ǰ�ĺϲ�����һ�����ɿ�֮ǰ����Ŀ
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode fast = head;
		ListNode slow = head;
		//����ָ���ҵ��м�ڵ�
		while(fast.next!=null &&fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode head2 = slow.next;
		//��������нض�
		slow.next = null;
		
		head = sortList(head);
		head2 = sortList(head2);
		
		return mergesort(head,head2);
	}

	private ListNode mergesort(ListNode list1, ListNode list2) {
		//ͷ��㣬���洢Ԫ��ֵ
		ListNode head = new ListNode(-1);
		//���б���
		ListNode p = head;
		while(list1!=null && list2!=null) {
			if(list1.val<list2.val){
				p.next = list1;
				list1 = list1.next;
			} else {
				p.next = list2;
				list2 = list2.next;
			}
			p = p.next;
		}
		
		if(list1!=null) { //ֱ�����Ӽ���
			p.next = list1;
		}
		if(list2!=null) {
			p.next = list2;
		}
		return head.next;
	}
}
