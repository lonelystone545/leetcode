package com.wy.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main010 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			char[] chs = str.toCharArray();
			Set<Character> set = new HashSet<Character>();
			for(char c : chs){
				if(c>=0 && c<=127) {
					set.add(c);
				}
			}
			System.out.println(set.size());
		}
	}
}
