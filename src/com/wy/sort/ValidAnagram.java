package com.wy.sort;

import java.util.HashMap;
import java.util.Map;
/*
 *  Given two strings s and t, write a function to determine if t is an anagram of s. 
	For example, 
	s = “anagram”, t = “nagaram”, return true. 
	s = “rat”, t = “car”, return false. 
	Note: 
	You may assume the string contains only lowercase alphabets
 *  变形词：两个单词中，每个字母出现的次数相同
 */
public class ValidAnagram {
	//map集合记录键(字符)和对应出现的次数
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
	
	//使用哈希表记录一个单词中字母出现的个数，再遍历第二个 单词，减去相应的字母出现的次数。如果某个字母的计数不为0，则说明出现次数不一样。
	public boolean isAnagram(String s,String t) {
		int[] nums = new int[26]; //这里假设只有英文字母
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
