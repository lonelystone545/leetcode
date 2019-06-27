package com.wy.linkedlist;

/*
 * 237. Delete Node in a Linked List
 *  Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

	Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

 */
public class DeleteNodeinaLinkedList {
	/*
	 * 思路：删除某一个节点。找不到前驱，只能换个思路，直接用值替代。
	 */
	public void deleteNode(ListNode node) {
        if(node.next==null) {
        	return;
        }
       node.val = node.next.val;
       node.next = node.next.next;
    }
}
