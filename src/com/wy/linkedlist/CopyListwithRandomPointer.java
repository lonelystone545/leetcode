package com.wy.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
 *138. Copy List with Random Pointer
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */
public class CopyListwithRandomPointer {
	//时间O(n) 空间O(1)
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode cur = head;
        //第一次遍历，复制每个节点 放在原节点的后面
        while(cur!=null) {
        	RandomListNode r = new RandomListNode(cur.label);
        	r.next = cur.next;
        	cur.next = r;
        	cur = r.next;
        }
        
        cur = head;
        //第二次遍历，添加对应的random
        while(cur!=null) {
        	if(cur.random!=null) {
        		cur.next.random = cur.random.next;
        	}
        	cur = cur.next.next;
        }
        
        RandomListNode nhead = head.next;
        cur = head;
        //第三次遍历 将链表分离
        while(cur!=null) {
        	RandomListNode tmp = cur.next;
        	cur.next = tmp.next;
        	if(tmp.next!=null) {
        		tmp.next = tmp.next.next;
        	}
        	cur = cur.next;
        }
        return nhead;
    }
	
	//时间O(n) 空间O(n) 使用map
	public RandomListNode copyRandomList2(RandomListNode head) {
		if(head==null) return null;
		Map<RandomListNode,RandomListNode> map = new HashMap<>();
		RandomListNode node = head;
		//将新旧节点对应的存进map
		while(node!=null) {
			map.put(node, new RandomListNode(node.label));
			node = node.next;
		}
		node = head;
		for(Map.Entry<RandomListNode, RandomListNode> entry:map.entrySet()) {
			RandomListNode newNode = entry.getValue();
			newNode.next = map.get(entry.getKey().next);
			newNode.random = map.get(entry.getKey().random);
		}
		return map.get(head);
	}
}

class RandomListNode {
	int label;
	RandomListNode next,random;
	RandomListNode(int x) {
		this.label = x;
	}
}