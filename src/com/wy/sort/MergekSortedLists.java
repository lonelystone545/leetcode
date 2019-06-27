package com.wy.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
 * 
 * ��k�����������ϲ���һ���µ���������
 * 1 ʹ�÷���˼�룬����ڹ鲢������������ݹ黮�֣�һ�ֶ���������...ֱ�����һ���������ĳ�Ϊһ�飬Ȼ���ٽ��й鲢
 * 	 ���ֲ��õĵݹ�ʵ�֣��鲢����ʹ������ķ�����ʱ�临�Ӷ�O(nlogn)
 * 2 ʹ�û��ڶѵ����ȼ����С�����������洢�����У�ÿ��poll���Ķ�����С��Ԫ�أ�Ȼ��Ѹ�Ԫ�ص���һ��Ԫ�����...
 */
public class MergekSortedLists {
	//��ʱ ʱ�临�Ӷ�O(2n+3n+4n+...kn)=O(nk^2)
	public ListNode mergeKLists2(ListNode[] lists) {
        for(int i=0;i<lists.length-1;i++) {
        	lists[i+1]= helper(lists[i],lists[i+1]);
        }
        return lists[lists.length-1];
    }

	private ListNode helper(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode p = head;
		while(l1!=null && l2!=null) {
			if(l1.val<l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if(l1!=null) {
			p.next=l1;
		}
		if(l2!=null) {
			p.next=l2;
		}
		return head.next;
	}
	
	@Test
	public void test(){
		ListNode[] lists = {null,null};
		System.out.println(lists.length); //2
		System.out.println(lists==null);  //fasle
		
	}
	
	//�����ڹ鲢���򣬲��÷��η�
	public ListNode mergeKLists(ListNode[] lists) {
		//���ﲻ��д��if(lists==null && lists.length==0)
		if(lists.length==0)  return null;
		return mergesort(lists,0,lists.length-1);
	}

	private ListNode mergesort(ListNode[] lists, int start, int end) {
		if(start==end) return lists[start];
		
		int mid = start + (end-start)/2;
		
		//���յݹ�ʱ�ϲ㷵�ص�ͷ�ڵ�
		ListNode left = mergesort(lists, start, mid);
		ListNode right = mergesort(lists, mid+1, end);
		//�ϲ�������������
		return merge(left,right);
	}

	private ListNode merge(ListNode list1,ListNode list2) {
		ListNode head = new ListNode(0);
		ListNode p = head;
		while(list1!=null && list2!=null) {
			if(list1.val<list2.val) {
				p.next = list1;
				list1 = list1.next;
			} else {
				p.next = list2;
				list2 = list2.next;
			}
			p = p.next;
		}
		if(list1!=null) {//lists[mid+1]==null
			p.next = list1;
		}
		if(list2!=null) {
			p.next = list2;
		}
		return head.next;
	}
	
	//ʹ�ö�
	public ListNode mergeKLists3(ListNode[] lists) {
		
		if(lists==null || lists.length==0) return null;
		
		Comparator<ListNode> com = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
			
		};
		
		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length,com);
		//��lists�����е�ͷ�ڵ����η���queue��
		for(int i=0;i<lists.length;i++) {
			if(lists[i]!=null) {
				heap.offer(lists[i]);
			}
		}
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		while(!heap.isEmpty()) {
			ListNode node = heap.poll(); //ÿ�ΰ���С�ĵ���
			p.next = node;
			p = node;
			if(node.next!=null) {
				heap.add(node.next);
			}
		}
		return head.next;
	}
}
