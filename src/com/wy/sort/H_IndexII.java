package com.wy.sort;

/*
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm
 */
public class H_IndexII {
	
	//������Ļ����ϣ���������
	public int hIndex2(int[] citations) {
		int length = citations.length;
		if(length==0) return 0;
		//����  �����->С��ʼ����
		int count = 0;
		for(int i=length-1;i>=0;i--) {
			if(count>=citations[i]) { //��ʱС��citations[i]�������ֻ��citations[i]-1��
				return count;
			}
			count++;
		}
		return count; //˵���������������count(0����С��count��count������count��
	}
	
	//���ö��ַ�����
	public int hIndex(int[] citations) {
		int length = citations.length;
		int left = 0,right=length-1,mid=0;
		while(left<=right) {
			mid=(left+right)>>1;
			if(citations[mid]==(length-mid)) { //citations[mid] papers������citations[mid] citations
				return citations[mid];
			} else if(citations[mid]>(length-mid)) { //û����ô���citations[mid] papers��Ӧ��������������
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		return length-(right+1);
	}
}
