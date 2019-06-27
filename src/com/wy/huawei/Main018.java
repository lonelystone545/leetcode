package com.wy.huawei;

import java.util.Scanner;
/*
 * ×ø±êÒÆ¶¯
 */
public class Main018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int x=0,y=0;
			String str = sc.nextLine();
			String[] strs = str.split(";");
			for(String s : strs) {
				int n = Integer.parseInt(s.substring(1));
				if(s.charAt(0)=='A')
					x -= n;
				if(s.charAt(0)=='D')
					x += n;
				if(s.charAt(0)=='W')
					y += n;
				if(s.charAt(0)=='S')
					y += n;
			}
			System.out.println(x+","+y);
		}
	}
}
