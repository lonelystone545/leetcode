package com.wy.leetcode;

/*
 * ���ַ������
 */
import java.util.ArrayList;
import java.util.List;

public class CombinationTest {
	public static void main(String[] args) {
		String s = "abcd";
		List<String> res = new ArrayList<String>();
		com(s,res);
		System.out.println("----------");
		com2(s.toCharArray());
	}
	
	public static List<String> com(String s,List<String> res) {
		//����Ϊi���ַ����
		for(int i=1;i<=s.length();i++) {
			com(s,res,i);
		}
		return res;
	}
	//�ַ�����startλ�ÿ�ʼѡȡnum���ַ����
	public static void com(String s,List<String> res,int num) {
		if(num==0) {
			System.out.println(res.toString());
			return;
		}
		if(s.length()!=0) {
			//ȡ��һ���ַ�
			res.add(s.charAt(0)+"");
			com(s.substring(1,s.length()),res,num-1);
			//��ȡ��һ���ַ�
			res.remove(res.size()-1);
			com(s.substring(1,s.length()),res,num);
		}
	}
	
	public static void com2(char[] chs) {
		List<String> res = new ArrayList<String>();
		for(int i=1;i<=chs.length;i++) {
			com2(chs,res,0,i);
		}
	}
	public static void com2(char[] chs,List<String> res,int start,int num) {
		if(num==0) {
			System.out.println(res.toString());
			return;
		}
		if(start==chs.length) {
			return;
		}
		res.add(chs[start]+"");
		com2(chs,res,start+1,num-1);
		res.remove(res.size()-1);
		com2(chs,res,start+1,num);
	}
}

