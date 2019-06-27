package com.wy.leetcode;

/*
 * ��ȫ����
 * 
 * ÿһ��ѭ���У���Ҫ��str[i]��str[i]�������λ�ã���һ�ο�ʼ��"a"���Լ�������ʱ�򣬵ݹ����arrange[str,st + 1, len]
��������ȡstr[str...len - 1]�����м�"b","c"�����У�
�ڶ��Σ�"a"��"b"����������ݹ����arrange[str,str + 1, len]��������ȡ{"a","c"}�����С�
�����Σ�"a"��"c"����������ݹ����arrange[str, str + 1,len]��������ȡ"{"b","a}�����С�
��������"b","c"��������ȡΪ����
���Ȼ�����ѭ������һ�Σ�"b"���Լ���������ʱ�򣬵���arrange[str,st + 1,len], ������c�����С��Ǻǣ���ʱ�����ڵ��˺����ݹ���õĳ�����
: st = len - 1�����"b" "c";
�ڶ��Σ����Ƶģ����"c","b";
���ˣ�"b" "c"��������ȡ��ϡ�����ǰ���a,�����"a""b""c" "a""c""b"��
���Ƶģ��Ϳ���������е������ˡ�
 */
public class PermulationTest {
	public static void main(String[] args) {
		String s = "aabb";
		permulation(s.toCharArray(),0);
	}
	
	public static void permulation(char[] chs,int start) {
		if(start==chs.length-1) {
			for(int i=0;i<chs.length;i++) {
				System.out.print(chs[i]);
			}
			System.out.println();
		} else {
			for(int i=start;i<chs.length;i++) { 
				//�������ظ������ֽ���  ����aabb��a(2)��b(3)����֮�󣬲�Ӧ��b(4)���н�����
				if(!isSwap(chs,start,i)) { //�������� ����ȥ���ظ�Ԫ�صĽ���
					swap(chs,start,i); 
					permulation(chs,start+1);
					swap(chs,start,i);
				}
			}
		}
	}
	
	public static boolean isSwap(char[] chs,int start,int end) {
		for(int i=start;i<end;i++) {
			if(chs[i]==chs[end]) {
				return true;
			}
		}
		return false;
	}
	
	public static void swap(char[] chs,int i,int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}
	
}
