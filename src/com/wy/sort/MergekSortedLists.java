package com.wy.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
 * 
 * 把k个有序的链表合并成一个新的有序链表
 * 1 使用分治思想，借鉴于归并排序。数组的数递归划分，一分二，二分四...直至最后一个数单独的成为一组，然后再进行归并
 * 	 划分采用的递归实现，归并可以使用上题的方法。时间复杂度O(nlogn)
 * 2 使用基于堆的优先级队列。把数组的数存储到堆中，每次poll出的都是最小的元素，然后把该元素的下一个元素入堆...
 */
public class MergekSortedLists {
	//超时 时间复杂度O(2n+3n+4n+...kn)=O(nk^2)
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
	
	//类似于归并排序，采用分治法
	public ListNode mergeKLists(ListNode[] lists) {
		//这里不能写成if(lists==null && lists.length==0)
		if(lists.length==0)  return null;
		return mergesort(lists,0,lists.length-1);
	}

	private ListNode mergesort(ListNode[] lists, int start, int end) {
		if(start==end) return lists[start];
		
		int mid = start + (end-start)/2;
		
		//接收递归时上层返回的头节点
		ListNode left = mergesort(lists, start, mid);
		ListNode right = mergesort(lists, mid+1, end);
		//合并两个有序链表
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
	
	//使用堆
	public ListNode mergeKLists3(ListNode[] lists) {
		
		if(lists==null || lists.length==0) return null;
		
		Comparator<ListNode> com = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
			
		};
		
		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length,com);
		//把lists数组中的头节点依次放入queue中
		for(int i=0;i<lists.length;i++) {
			if(lists[i]!=null) {
				heap.offer(lists[i]);
			}
		}
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		while(!heap.isEmpty()) {
			ListNode node = heap.poll(); //每次把最小的弹出
			p.next = node;
			p = node;
			if(node.next!=null) {
				heap.add(node.next);
			}
		}
		return head.next;
	}
}
