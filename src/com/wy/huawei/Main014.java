package com.wy.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * �ִ��������·������
 * @author wy
 * ����n���ַ��������n���ַ��������ֵ�������
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
