package com.wy.huawei;

import java.util.Scanner;
/*
 * ����һ����������ֵ���������ֵ�Ľ�������ֵ��
 * ���С�������ֵ���ڵ���5,����ȡ����С��5��������ȡ����
 */
public class Main007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			double d = sc.nextDouble();
			//ǿ��ת������һ���ϸ��ȡ�����㣬��������������
			int i = (int)d;
			if((d-i)>=0.5){
				System.out.println(i+1);
			} else {
				System.out.println(i);
			}
			System.out.println("--------------");
			System.out.println((d-i)>=0.5?i+1:i);
			System.out.println("--------------");
			d+=0.5;
			System.out.println((int)d);
		}
	}
}
