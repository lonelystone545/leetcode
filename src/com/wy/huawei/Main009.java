package com.wy.huawei;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * ����һ��int�����������մ���������Ķ�˳�򣬷���һ�������ظ����ֵ��µ�����
 * @author wy
 *
 */
public class Main009 {
	public static void main(String[] ags) {
		/*
		//ʹ��LinkedHashSetʵ����������Ҵ洢��������Ψһ��
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] chs = str.toCharArray();
		Set<Character> set = new LinkedHashSet<Character>();
		for(int i=chs.length-1;i>=0;i--){
			set.add(chs[i]);
		}
		for(char ch: set) {
			System.out.print(ch);
		}
		*/
		@SuppressWarnings("resource")
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            int len=s.length();
            int []arr1=new int[10];
            for(int i=len-1;i>=0;i--){
                if(arr1[s.charAt(i)-48]==0){
                    System.out.print(s.charAt(i)-48);
                    arr1[s.charAt(i)-48]++;
                }
            }
        }
	}
}

        

