package com.wy.huawei;

import java.util.Scanner;
//计算字符串最后一个单词的长度，单词以空格隔开。
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
