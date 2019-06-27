package com.wy.huawei;

import java.util.Scanner;

public class Main015 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		/*
		while(sc.hasNext()){
			int count = 0;
			int x = sc.nextInt();
			String s = Integer.toBinaryString(x);
			for(int i=0;i<s.length();i++){
				if(s.charAt(i) == '1'){
					count++;
				}
			}
			System.out.println(count);
		}
		*/
		while(sc.hasNext()){
			int n = sc.nextInt();
			int count = 0;
			while(n!=0){
				count++;
				n=n&(n-1);
			}
			System.out.println(count);
		}
		sc.close();
	}
}
