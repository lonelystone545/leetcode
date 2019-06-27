package com.wy.tree.traversal;
/*
 *       1
       /  \
      2    3
     / \    \
    4   5    7
    变为
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers116 {
	//通用的解法，适用于所有二叉树
	public void connect(TreeLinkNode root) {
		if(root==null) return;
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			TreeLinkNode tmp = null;
			for(int i=0;i<size;i++) {
				TreeLinkNode node1 = queue.poll();
				if(node1.left!=null) {
					queue.offer(node1.left);
				}
				if(node1.right!=null) {
					queue.offer(node1.right);
				}
				if(tmp!=null) {
					tmp.next=node1;
				}
				if(i==size-1) {
					node1.next=null;
					tmp=null;
					continue;
				}
				tmp = node1;
			}
		}
	}
	
	//通用的解法，适用于所有二叉树
	//与上一方法类似
	public void connect3(TreeLinkNode root) {
		if(root==null) return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		//记录每层节点的总数
		int numOfLevelNode = 1;
		while(!queue.isEmpty()) {
			TreeLinkNode node = queue.poll();
			numOfLevelNode--;
			if(node.left!=null) {
				queue.offer(node.left);
			}
			if(node.right!=null) {
				queue.offer(node.right);
			}
			if(numOfLevelNode>0) {
				node.next=queue.peek();
			} else {
				numOfLevelNode=queue.size();
			}
		}
	}
	
	
	/*
	 *  以下解法只适应于完全二叉树
		如果当前节点有左孩子，那么左孩子的next就指向右孩子；如果当前节点有右孩子，
		那么判断，如果当前节点的next是null，则说明当前节点已经在最右边，那么右孩子也是最右边，
		所以右孩子指向null；如果当前节点的next不是null，那么当前节点的右孩子的next需要指向当前节点
		next的左孩子
	 */
	public void connect2(TreeLinkNode root) {
		if(root==null) return;
		if(root.left!=null) {
			root.left.next = root.right;
		}
		if(root.right!=null) {
			if(root.next==null) {
				root.right.next=null;
			} else {
				root.right.next=root.next.left;
			}
		}
		connect2(root.left);
		connect2(root.right);
	}
	
	//只适应于完全二叉树 
	//原理：在遍历上一层的节点时，完成下一层节点的链接过程
	//两个指针：next始终指向一层的最左节点next=parent.left
	//prev指针负责遍历一层的节点并且进行链接prev=prev.next 
	 public void connect4(TreeLinkNode root) {
	        if (root == null) {
	            return;
	        }
	        TreeLinkNode parent = root;
	        TreeLinkNode next = parent.left;
	        while (parent != null && next != null) {
	            TreeLinkNode prev = null;
	            while (parent != null) {
	                if (prev == null) {
	                    prev = parent.left;
	                } else {
	                    prev.next = parent.left;
	                    prev = prev.next;
	                }
	                prev.next = parent.right;
	                prev = prev.next;
	                parent = parent.next;
	            }
	            parent = next;
	            next = parent.left;
	        }
	    }
}

