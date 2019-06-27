package com.wy.sort;

/*
 * Sort a linked list using insertion sort.
 * �������򣺰Ѵ������е����ݲ��뵽�Ѿ�����õ����С�
 *     �������������ʱ���ڱȽ�Ԫ��ʱ�Ǵ�����λ�ÿ�ʼ�Ƚϣ������������У�ÿ�ζ���Ҫһ��preָ�룬
 *     ��ͷ��㿪ʼ�����������Ҫά��һ��dummyNode��Ϊͷ��㣬ʹ���������Ĳ�������һ���ԡ�
 *     pre��ÿ�δ�dummyNode��ʼ���������κ͵�ǰ����Ľ��cur���бȽ�
 *          ���С�ڣ���ֻ��Ҫ�����ƶ�preָ�뼴�ɣ�������ڣ���Ҫ��cur����ƶ���pre����ǰ�棬��������û��ָ��ǰ����
 *          ��ָ�룬��˽�pre.next����cur�����бȽϣ������ǰ�pre��cur���Ƚϡ�
 *     cur����ǰ���ڲ���Ľ��
 *     next����ǰ���ڲ���Ľ�����һ�����
 * 	
 * ʱ�临�Ӷ�O(n^2) �ռ临�Ӷ�O(1)
 * 
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if(head==null || head.next==null) return head;
        //ͷ���dummyNode ��󷵻�ʱ��Ҫ����dummyNode.next
		ListNode dummyNode = new ListNode(-1);
		//��ǰҪ����Ľڵ�
		ListNode cur = head;
		while(cur!=null) {
			//nextָ��ǰ����ڵ����һ���ڵ�
			ListNode next = cur.next;
			//preʼ�մ�dummyNode��ʼ����
			ListNode pre = dummyNode;
			//��������<����ʵҲ������<=,�����Ļ������ȶ�������
			while(pre.next!=null && pre.next.val<cur.val) {
				//preָ������ƶ�
				pre = pre.next;
			}
			//��ʱpre.next��Ԫ��>curԪ��ֵ����Ҫ��curԪ�ز��뵽pre.nextԪ��ǰ��
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		return dummyNode.next;
    }
}
