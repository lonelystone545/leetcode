package com.wy.huawei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main006 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			long i = sc.nextLong();
			// List<Integer> list = fun1(i);
			// Iterator iterator = list.iterator();
			// while(iterator.hasNext()){
			// System.out.println(iterator.next());
			// }
			// System.out.println(fun2(i));
			System.out.println(fun3(i));
		}
	}

	// ��һ����������(��fun2��ͬ��
	public static String fun3(long num) {
		
		int i=2;
		StringBuilder sb = new StringBuilder();
		while(num!=1){
			if(num % i ==0){
				sb.append(i).append(" ");
				num=num/i;
			} else {
				i++;
			}
		}
		return sb.toString();	
	}

	// �ж�һ�����ǲ�������
	public static boolean suShu(int num) {
		int i = 2;
		while (i <= num / 2) {
			if (num % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}

	// ��һ��������������
	public static List<Integer> fun1(int num) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				list.add(i);
			}
		}
		list.add(1);
		list.add(num);
		return list;
	}

	// ��һ���������Ӹ���
	// Ҫ�� �㷨���Ӷ�O(sqrt(N))
	public static int fun2(int num) {
		if (num == 1)
			return 1;
		int count = 2;
		int r;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				if (i == Math.sqrt(num)) {
					r = num / i;
					if (r == i) {
						count++;
					} else {
						count += 2;
					}
				} else {
					count += 2;
				}
			}
		}
		return count;
	}
}
