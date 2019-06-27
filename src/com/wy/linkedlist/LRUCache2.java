package com.wy.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * LinkedHashMap是基于哈希表和链表实现的。默认的是按照元素添加的顺序进行存储。也可以启用按照访问顺序存储，即最近读取的数据放在
 * 最前面，最早读取的数据放在最后面，还有一个判断是否删除最老数据的方法，默认是false，即不删除数据。
 */
public class LRUCache2 {
	private LinkedHashMap<Integer, Integer> map;
	private int capacity;
	public LRUCache2(int capacity) {
		this.capacity = capacity;
		//true表明是按照读取数据的顺序进行存放数据。越晚读取的，放在链表头部。
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

