package com.wy.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * LinkedHashMap�ǻ��ڹ�ϣ�������ʵ�ֵġ�Ĭ�ϵ��ǰ���Ԫ����ӵ�˳����д洢��Ҳ�������ð��շ���˳��洢���������ȡ�����ݷ���
 * ��ǰ�棬�����ȡ�����ݷ�������棬����һ���ж��Ƿ�ɾ���������ݵķ�����Ĭ����false������ɾ�����ݡ�
 */
public class LRUCache2 {
	private LinkedHashMap<Integer, Integer> map;
	private int capacity;
	public LRUCache2(int capacity) {
		this.capacity = capacity;
		//true�����ǰ��ն�ȡ���ݵ�˳����д�����ݡ�Խ���ȡ�ģ���������ͷ����
		map = new LinkedHashMap<Integer,Integer>(capacity, 0.75f, true){
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
				return size()>capacity;
			}
		};
	}
	    
	public int get(int key) {
		return map.getOrDefault(key, -1);
	}
		    
	public void put(int key, int value) {
		map.put(key, value);    
	}
	
	
}

