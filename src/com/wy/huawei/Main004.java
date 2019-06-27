package com.wy.huawei;

import java.util.Scanner;

public class Main004 {
	/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		Split(s1);
		Split(s2);
	}

	private static void Split(String s) {
		int n = s.length();
		int l=0;
		if(n%8>0){
			l=8-n%8;
		}
		StringBuilder sb = new StringBuilder(s);
		while(l>0){
			sb.append("0");
			l--;
		}
		
		int i=n/8+1;
		for(int j=0;j<i;j++){
			if(j*8+8<=sb.length()){
				String  ss = sb.substring(j*8,j*8+8);
				System.out.println(ss);
			}
		}
	}
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.nextLine();
			if(s.length()%8!=0){
				s=s+"00000000";
			}
			
			while(s.length()>=8){
				System.out.println(s.substring(0,8));
				s=s.substring(8);
			}
		}
	}
}
