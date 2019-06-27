package com.wy.huawei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
/*
 * 随机生成N个1-1000的数字，去除重复的数字，剩下的数字按照从小到大输出
 * 
 * 
 * 思路：删除重复元素 ---使用Set集合
 * 		顺序输出--TreeSet
 */
public class Main003 {
	public static void main(String[] args) {
		//理解有错误。。使用题目中的案例，而不是自己生成随机数
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		TreeSet<Integer> ts = new TreeSet<Integer>();
//		while (n-- != 0) {
//			int number = (int) (Math.random() * 1000) + 1;
//			ts.add(number);
//		}
//		System.out.println("-----------------");
//		Iterator<Integer> iterator = ts.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int num= sc.nextInt();
			TreeSet<Integer> ts = new TreeSet<Integer>();
			for(int i=0;i<num;i++){
				int curr = sc.nextInt();
				ts.add(curr);
			}
			for(Integer i : ts) {
				System.out.println(i);
			}
		}
	}
}
