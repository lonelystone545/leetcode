package com.wy.test;

import java.util.ArrayList;
import java.util.List;
/*
 * q为素数，p为大于2的正整数，p^q次幂
 */
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long num = sc.nextLong();
		int p=0,q=0;
		long time1 = System.currentTimeMillis();
		for(int i=2;i<=Math.sqrt(num);i++) {
			while(num%i==0) {
				num = num/i;
				q++;
				if(num==1) {
					p = i;
					System.out.println(p+" "+q);
					long time2 = System.currentTimeMillis();
					System.out.println(time2-time1+"------------");
					return;
				}
			}
		}
		System.out.println("No");
//		primes(100);
	}
	
	//求素数
//	@org.junit.Test
	public static List<Integer> primes(int n) {
		List<Integer> res = new ArrayList<Integer>();
		
		for(int i=2;i<=n;i++) {
			boolean flag = true;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					flag=false;
					break;
				}
			}
			if(flag) {
				System.out.println(i);
				res.add(i);
			}
		}
		return res;
	}
}
