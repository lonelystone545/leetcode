package com.wy.tree.bst;

/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 给出一个单链表，里面的元素是升序排列。
 * 普通解法是把单链表转化成数组，然后采用上题解法。这里不予给出了。
 */
public class ConvertSortedListtoBST109 {
	
	//设置一个快慢指针，快指针每次两步，慢指针每次一步，这样快指针到头的时候，慢指针正好到中间
	 public TreeNode sortedListToBST2(ListNode head) {
		 	if(head==null) return null;
		 	return helper(head,null);
	    }

	private TreeNode helper(ListNode head, ListNode target) {
		if(head == target) return null;
		ListNode fast = head;
        ListNode slow = head;
        while(fast!=target && fast.next!=target) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        //此时slow到达中间位置
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head,slow);
        root.right = helper(slow.next,target);
		return root;
	}
	
	
	//设置一个全局变量
	ListNode curr;
	//自底向上建立BST
	public TreeNode sortedListToBST(ListNode head) {
		curr = head;
		int len = 0;
		//计算链表的长度
		while(head!=null) {
			head = head.next;
			len++;
		}
		//建树
		return buildTree(0,len-1);
	}

	private TreeNode buildTree(int start, int end) {
		//没有子节点，直接返回
		if(start>end) return null;
		int mid = start+(end-start)/2; //防止溢出
		TreeNode left = buildTree(start, mid-1);
		TreeNode root = new TreeNode(curr.val);
		//链表顺序遍历
		curr = curr.next;
		TreeNode right = buildTree(mid+1, end);
		//将节点链接起来
		root.left = left;
		root.right = right;
		return root;
	}
}
