package com.wy.huawei;

import java.util.Scanner;
//�����ַ������һ�����ʵĳ��ȣ������Կո������
public class Main001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ss = "";
		while(sc.hasNextLine()){
			ss = sc.nextLine();
			String[] str = ss.split(" ");
			int n = str[str.length-1].length();
			System.out.println(n);
			System.out.println(ss.length()-1-ss.lastIndexOf(" "));
		}
	}
}
