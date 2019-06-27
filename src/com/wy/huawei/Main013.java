package com.wy.huawei;

import java.util.Scanner;

/**
 * ¾ä×Ó·´×ª
 * 
 * @author wy
 *
 */
public class Main013 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = reverse(sc.nextLine());
			System.out.println(s);
		}
	}

	public static String reverse(String sentence) {
		String[] strs = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = strs.length - 1; i >= 0; i--) {
			if (i != 0) {
				sb.append(strs[i] + " ");
			} else {
				sb.append(strs[i]);
			}
		}
		return sb.toString();
	}
}
