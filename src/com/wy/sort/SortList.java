package com.wy.sort;

/*
 * Sort List 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * O(nlogn)的排序算法有归并、快排和堆排序。快排用于双向链表比较多，单向链表适合用归并排序。
 * 
 * 关键是找到中间节点，这里采用了快慢指针，当快指针遍历结束后，慢指针所在的位置就是中间位置。
 * 然后以慢指针的下一个节点作为新的头部，并对其进行截断，这样，一个链表就被分割成了两个链表。
 * 至于合并操作，跟之前的合并链表一样，可看之前的题目
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode fast = head;
		ListNode slow = head;
		//快慢指针找到中间节点
		while(fast.next!=null &&fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode head2 = slow.next;
		//对链表进行截断
		slow.next = null;
		
		head = sortList(head);
		head2 = sortList(head2);
		
		return mergesort(head,head2);
	}

	private ListNode mergesort(ListNode list1, ListNode list2) {
		//头结点，不存储元素值
		ListNode head = new ListNode(-1);
		//进行遍历
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
		
		if(list1!=null) { //直接链接即可
			p.next = list1;
		}
		if(list2!=null) {
			p.next = list2;
		}
		return head.next;
	}
}
