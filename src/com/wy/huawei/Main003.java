package com.wy.huawei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
/*
 * �������N��1-1000�����֣�ȥ���ظ������֣�ʣ�µ����ְ��մ�С�������
 * 
 * 
 * ˼·��ɾ���ظ�Ԫ�� ---ʹ��Set����
 * 		˳�����--TreeSet
 */
public class Main003 {
	public static void main(String[] args) {
		//����д��󡣡�ʹ����Ŀ�еİ������������Լ����������
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
