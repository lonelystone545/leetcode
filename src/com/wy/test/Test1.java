package com.wy.test;
/*
 * ��һ��������N�ͳ���L���ҳ�һ�γ��ȴ��ڵ���L�������Ǹ�������ʹ���ǵĺ�ǡ��ΪN
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
   
        int a = in.nextInt();
        int b = in.nextInt();
        int begin = a/b+b/2;
        if(begin > a)  //b=1
        {
        	begin = a;
        }
        int sum = 0;
        List<Integer> list = new ArrayList();
        //�������ٴ����￪ʼ
        while(begin>0) {
            int i=0;
            for(i=begin; i>0; i--) {
            	sum = sum + i;
            	if(sum>=a) {
            		break;
            	}
            }
            if(sum == a && begin-i>=b-1) {
            	for(int j=begin; j>=i; j--) {
            		list.add(j);
            	}
            	break;
            }
        sum = 0;
        begin--;
        }
       //�Ѿ��õ���list��
        //�ҵ���̵��Ǹ���list
        if(list.size()>=1) {
        	for(int d:list) {
        		System.out.print(d+"  ");
        	}
        }else {
        	System.out.println("No");
        }
    }
}


