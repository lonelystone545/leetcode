package com.wy.sort;

import java.util.Collections;
import java.util.List;
/*
 * 524. Longest Word in Dictionary through Deleting 
 * 
 *  Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string. 
	Example 1:
	Input:
	s = "abpcplea", d = ["ale","apple","monkey","plea"]

	Output: 
	"apple"


	Example 2:
	Input:
	s = "abpcplea", d = ["a","b","c"]

	Output: 
	"a"

	Note:
	All the strings in the input will only contain lower-case letters.
	The size of the dictionary won't exceed 1,000.
	The length of all the strings in the input won't exceed 1,000.
 */
public class LongestWordinDictionarythroughDeleting524 {
	//�������
	//����d�е�ÿ���ַ�����������s���бȽ�
    public String findLongestWord(String s, List<String> d) {
    	//����֮�󣬱�֤�ֵ������
        Collections.sort(d);
        String result="";
        for(String dd : d) {
        	int i=0,j=0;
        	while(i<s.length()&&j<dd.length()) {
        		if(s.charAt(i)==dd.charAt(j)) {
        			i++;
        			j++;
        		} else {
        			i++;
        		}
        	}
        	if(j==dd.length()&& result.length()<dd.length()) {
        		result = dd;
        	}
        }
        return result;
    }
}
