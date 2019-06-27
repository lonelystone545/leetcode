package com.wy.linkedlist;

/*
 * 142. Linked List Cycle II
 * 
 *  Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

	Note: Do not modify the linked list.
	
	
	��fast��slow����ʱ��slow�϶�û�б�����������fast�Ѿ��ڻ���ѭ����nȦ������slow����s������fast����2s����
	����Ϊr������2s = s+nr;   s = nr������������L������ڵ������������Ϊa����㵽����ڵ����Ϊx����
	x+a=nr=(n-1)r+r=(n-1)r+L-x    x=(n-1)r+(L-x-a)
	L-x-aΪ�����㵽��ڵ���롣��֪��������ͷ������ڵ����n-1Ȧ�ڻ�+�����㵽����ڵ㣬���ǿ��Դ�head��ʼ��
	����һ��ָ��slow2��������ָ��ÿ��ǰ��һ��������һ�����ڻ���ڵ�������
 */
public class LinkedListCycleII {
	/*
	 * ˫ָ�뷨��fast��slow��һ������ʱ����ʱ����һ��slow2��head������slow�����ߣ����´�slow2��slow����ʱ��Ϊ��ڵ㡣
	 */
	public ListNode detectCycle(ListNode head) {
		if(head==null || head.next==null) return null;
		ListNode slow = head;
		ListNode fast = head;
		boolean flag = false;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) {
				flag = true;
				break;
			}
		}
		if(flag){
			ListNode slow2 = head;
			while(slow!=slow2) {
				slow = slow.next;
				slow2 = slow2.next;
			}
		} else {
			return null;
		}
		return slow;
    }
}
