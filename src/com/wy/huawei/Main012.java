package com.wy.huawei;

import java.util.Scanner;

public class Main012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			char[] chs = str.toCharArray();
			for(int i=chs.length-1;i>=0;i--){
				System.out.print(chs[i]);
			}
		}
	}
}	
