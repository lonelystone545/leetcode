package com.wy.huawei;

/**
 * Êý×Öµßµ¹
 */
import java.util.Scanner;

public class Main011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			for(int i=str.length()-1;i>=0;i--){
				sb.append(str.charAt(i));
			}
			System.out.println(sb.toString());
		}
	}
}
