package com.wy.sort;

import java.util.HashMap;
import java.util.Map;
/*
 *  Given two strings s and t, write a function to determine if t is an anagram of s. 
	For example, 
	s = ��anagram��, t = ��nagaram��, return true. 
	s = ��rat��, t = ��car��, return false. 
	Note: 
	You may assume the string contains only lowercase alphabets
 *  ���δʣ����������У�ÿ����ĸ���ֵĴ�����ͬ
 */
public class ValidAnagram {
	//map���ϼ�¼��(�ַ�)�Ͷ�Ӧ���ֵĴ���
	public boolean isAnagram2(String s,String t) {
		Map<Character,Integer> map = new HashMap<>();
		if(s.length()!=t.length()) return false;
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			} else {
			map.put(s.charAt(i), 1);
			}
		}
		
		for(int i=0;i<t.length();i++) {
			if(map.containsKey(t.charAt(i))&&map.get(t.charAt(i))>0) {
				map.put(t.charAt(i), map.get(t.charAt(i))-1);
			} else {
				return false;
			}
		}
		return true;
	}
	
	//ʹ�ù�ϣ���¼һ����������ĸ���ֵĸ������ٱ����ڶ��� ���ʣ���ȥ��Ӧ����ĸ���ֵĴ��������ĳ����ĸ�ļ�����Ϊ0����˵�����ִ�����һ����
	public boolean isAnagram(String s,String t) {
		int[] nums = new int[26]; //�������ֻ��Ӣ����ĸ
		for(int i=0;i<s.length();i++) {
			nums[s.charAt(i)-'a']++;
		}
		for(int i=0;i<t.length();i++) {
			nums[t.charAt(i)-'a']--;
		}
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) return false;
		}
		return true;
	}
}
