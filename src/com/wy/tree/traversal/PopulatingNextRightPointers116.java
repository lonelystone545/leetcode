package com.wy.tree.traversal;
/*
 *       1
       /  \
      2    3
     / \    \
    4   5    7
    ��Ϊ
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers116 {
	//ͨ�õĽⷨ�����������ж�����
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
	
	//ͨ�õĽⷨ�����������ж�����
	//����һ��������
	public void connect3(TreeLinkNode root) {
		if(root==null) return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		//��¼ÿ��ڵ������
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
	 *  ���½ֻⷨ��Ӧ����ȫ������
		�����ǰ�ڵ������ӣ���ô���ӵ�next��ָ���Һ��ӣ������ǰ�ڵ����Һ��ӣ�
		��ô�жϣ������ǰ�ڵ��next��null����˵����ǰ�ڵ��Ѿ������ұߣ���ô�Һ���Ҳ�����ұߣ�
		�����Һ���ָ��null�������ǰ�ڵ��next����null����ô��ǰ�ڵ���Һ��ӵ�next��Ҫָ��ǰ�ڵ�
		next������
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
	
	//ֻ��Ӧ����ȫ������ 
	//ԭ���ڱ�����һ��Ľڵ�ʱ�������һ��ڵ�����ӹ���
	//����ָ�룺nextʼ��ָ��һ�������ڵ�next=parent.left
	//prevָ�븺�����һ��Ľڵ㲢�ҽ�������prev=prev.next 
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

