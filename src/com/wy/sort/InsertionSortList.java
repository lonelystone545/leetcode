package com.wy.sort;

/*
 * Sort a linked list using insertion sort.
 * 插入排序：把待排序列的数据插入到已经排序好的序列。
 *     对数组插入排序时，在比较元素时是从最后的位置开始比较，但是在链表中，每次都需要一个pre指针，
 *     从头结点开始遍历，因此需要维护一个dummyNode作为头结点，使对其他结点的操作具有一致性。
 *     pre：每次从dummyNode开始遍历，依次和当前插入的结点cur进行比较
 *          如果小于，则只需要继续移动pre指针即可；如果大于，需要把cur结点移动到pre结点的前面，但是这里没有指向前面结点
 *          的指针，因此将pre.next结点和cur结点进行比较，而不是把pre和cur结点比较。
 *     cur：当前正在插入的结点
 *     next：当前正在插入的结点的下一个结点
 * 	
 * 时间复杂度O(n^2) 空间复杂度O(1)
 * 
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if(head==null || head.next==null) return head;
        //头结点dummyNode 最后返回时主要返回dummyNode.next
		ListNode dummyNode = new ListNode(-1);
		//当前要插入的节点
		ListNode cur = head;
		while(cur!=null) {
			//next指向当前插入节点的下一个节点
			ListNode next = cur.next;
			//pre始终从dummyNode开始遍历
			ListNode pre = dummyNode;
			//这里用了<，其实也可以用<=,这样的话就是稳定排序了
			while(pre.next!=null && pre.next.val<cur.val) {
				//pre指针继续移动
				pre = pre.next;
			}
			//此时pre.next的元素>cur元素值，需要把cur元素插入到pre.next元素前面
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		return dummyNode.next;
    }
}
