package com.wy.test;

public class SortTest {
	
	//first missing number
	public int test1(int[] nums) {
		if(nums==null || nums.length==0) return -1;
		for(int i=0;i<nums.length;i++) {
			while(nums[i]>0 && nums[i]<=nums.length && nums[i]!=i+1) {
				int tmp = nums[nums[i]-1];
				if(tmp == nums[i]) {
					break;
				}
				nums[nums[i]-1] = nums[i];
				nums[i] = tmp;
			}
		}
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=i+1) {
				return i+1;
			}
		}
		return nums.length;
	}
	
	//h index
	public int test2(int[] citations) {
		if(citations==null || citations.length==0) return 0;
		int[] arr = new int[citations.length+1];
		for(int i=0;i<citations.length;i++) {
			if(citations[i]>=citations.length) {
				arr[citations.length]++;
			} else {
				arr[citations[i]]++;
			}
		}
		int sum = 0;
		for(int i=arr.length-1;i>=0;i--) {
			sum += arr[i];
			if(sum>=i) return i;
		}
		return 0;
	}
	
	//h indexII
	public int test3(int[] citations) {
		if(citations==null || citations.length==0) {
			return 0;
		}
		int count = 0;
		for(int i=citations.length-1;i>=0;i--) {
			if(count>citations[i]) {
				return count;
			}
			count++;
		}
		return count;
	}
	
	//insert sorted list
	public ListNode test4(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode cur = head;
		while(cur!=null) {
			ListNode next = cur.next;
			ListNode pre = dummyNode;
			while(pre.next!=null && pre.next.val<cur.val) {
				pre = pre.next;
			}
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		return dummyNode.next;
	}
	
	public ListNode test(ListNode head) {
		
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode cur = head;
		ListNode tail = head;
		while(tail.next!=null) {
			tail = tail.next;
		}
		while(cur.next!=null) {
			ListNode tmp = dummyNode;
			while(tmp.next.next != tail) {
				if(tmp.next.val>tmp.next.next.val) {
					ListNode next = tmp.next.next.next;
					ListNode t = tmp.next;
					tmp.next = t.next;
					tmp.next.next = t;
					t.next = next;
				}
			}
			tail = tmp.next;
		}
		return dummyNode.next;
	}
}

class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}
