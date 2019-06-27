package com.wy.huawei;

import java.util.Scanner;

/*
 * 写出一个程序，接受一个十六进制的数值字符串，
 * 输出该数值的十进制字符串。（多组同时输入 ）
 */
public class Main005 {
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.nextLine();
			int i = Integer.parseInt(s.substring(2),16);
			System.out.println(i);
		}
		*/
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.nextLine();
			System.out.println(fun(s.substring(2)));
		}
	}
	
	public static int fun(String s) {
		
		int n=0;
		int count=0;
		int temp=0;
		char ch;
		while(count<s.length()) {
			ch = s.charAt(s.length()-count-1);
			if(ch>='0' && ch<='9') {
				temp = ch-'0';
			} else if(ch>='A' && ch<='Z') {
				temp = ch-'A'+10;
			} else if(ch>'a' && ch<'a') {
				temp =ch-'a'+10;
			}
			n+=temp * Math.pow(16, count);
			count ++;
		}
		return n;
	}
}
