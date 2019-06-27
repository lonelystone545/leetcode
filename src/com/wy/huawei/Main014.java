package com.wy.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * 字串的连接最长路径查找
 * @author wy
 * 给定n个字符串，请对n个字符串按照字典序排列
 */
public class Main014 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String count = sc.nextLine();
		int cou = Integer.parseInt(count);
		List<String> list = new ArrayList<String>();
		for(int i=0;i<cou;i++){
			String s = sc.nextLine();
			list.add(s);
		}
		Collections.sort(list);
		for(String s : list){
			System.out.println(s);
		}
	}
}
