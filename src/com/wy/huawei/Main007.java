package com.wy.huawei;

import java.util.Scanner;
/*
 * 接受一个正浮点数值，输出该数值的近似整数值。
 * 如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 */
public class Main007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			double d = sc.nextDouble();
			//强制转换，是一种严格的取整运算，并不是四舍五入
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
