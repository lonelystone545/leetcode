package com.wy.huawei;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
//nextInt()���Կո���߻س�����һ���������
//nextLine(),�ո���Ϊ�ַ�����һ���֣�ֻ�лس���һ���������
public class Main008 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		while(sc.hasNext()){
			int num = sc.nextInt();
			for(int i=0;i<num;i++){
				int key = sc.nextInt();
				int value = sc.nextInt();
				if(map.containsKey(key)){
					map.put(key, map.get(key)+value);
				} else {
					map.put(key, value);
				}
			}
			
			for(Integer key : map.keySet()){
				System.out.println(key+" "+map.get(key));
			}
		}
		/*
		//����ʱ��������Խ�磨δ�飩
		Scanner sc = new Scanner(System.in);
		String snum = sc.nextLine();
		int num = Integer.valueOf(snum);
		Map map = new HashMap();
		for(int i=0;i<num;i++){
			String s = sc.nextLine();
			String[] ss = s.split(" ");
			if(map.containsKey(ss[0])){
				int m = Integer.valueOf((String) map.get(ss[0]));
				int n = Integer.valueOf(ss[1]);
				map.put(ss[0],m+n);
			} else {
				map.put(ss[0], ss[1]);
			}		
		}
		//����
		Iterator iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry entry = (Map.Entry)iterator.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key+" "+value);
		}
		*/
		
		
	}
}
