package com.wy.huawei;

import java.util.Scanner;

/*
 * д��һ�����򣬽���һ������ĸ�������Լ��ո���ɵ��ַ�����
 * ��һ���ַ���Ȼ����������ַ����к��и��ַ��ĸ����������ִ�Сд��
 */
public class Main002 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String s1 = sc.nextLine();
//		String s2 = sc.nextLine();
//		char[] ch1 = s1.toCharArray();
//		int number=0;
//		for(Character ch : ch1){
//			if(ch.toString().equalsIgnoreCase(s2)){
//				number++;
//			}	
//		}
//		System.out.println(number);
		int count=0;
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		String ss1 = s1.toUpperCase();
		String ss2 = s2.toUpperCase();
		
		char ch = ss2.charAt(0);
		for(int i=0;i<ss1.length();i++){
			if(ss1.charAt(i)==ch){
				count++;
			}
		}
		System.out.println(count);
	}
}
