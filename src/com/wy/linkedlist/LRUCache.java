package com.wy.linkedlist;

/*
 * 	146. LRU Cache
 * 	Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

	get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
	put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 
 	思路：LRU算法   即最近最少使用算法。是一种根据历史记录进行淘汰数据的算法。
 		 这里要求时间复杂度O(1)，故使用链表和哈希表，链表可以做到删除和添加时的O(1)，哈希表在查询时可以做到O(1)
 */
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private Map<Integer,DoubleLinkedListNode> map = new HashMap<>();
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode end;
	private int capacity;
	private int len;
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
        len = 0;
	}
	    
	public int get(int key) {
		if(map.containsKey(key)) {
			DoubleLinkedListNode latest = map.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.value;
		} else {
			return -1;
		}
	}
		    
	public void put(int key, int value) {
		if(map.containsKey(key)) {
			DoubleLinkedListNode oldNode = map.get(key);
			oldNode.value = value;
			removeNode(oldNode);
			setHead(oldNode);
		} else {
			DoubleLinkedListNode newNode = new DoubleLinkedListNode(key,value);
			if(len<capacity) {
				setHead(newNode);
				map.put(key, newNode);
				len++;
			} else {
				map.remove(end.key);
				end = end.pre;
				if(end!=null) {
					end.next = null;
				}
				setHead(newNode);
				map.put(key, newNode);
			}
		}
		        
	}
	
	private void setHead(DoubleLinkedListNode node) {
		node.next = head;
		node.pre = null;
		if(head!=null) {
			head.pre = node;
		}
		head = node;
		if(end==null) {
			end = node;
		}
	}

	private void removeNode(DoubleLinkedListNode node) {
		DoubleLinkedListNode cur = node;
		DoubleLinkedListNode pre= cur.pre;
		DoubleLinkedListNode post = cur.next;
		if(pre!=null) {
			pre.next = post;
		} else {
			head = post;
		}
		if(post!=null) {
			post.pre = pre;
		} else {
			end = pre;
		}
	}
}

//双向链表节点
class DoubleLinkedListNode {
	int key;
	int value;
	DoubleLinkedListNode pre;
	DoubleLinkedListNode next;
	
	public DoubleLinkedListNode(int key,int value) {
		this.key = key;
		this.value = value;
	}
}
