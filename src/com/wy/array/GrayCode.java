package com.wy.array;

import java.util.ArrayList;
import java.util.List;

/*
 *  The gray code is a binary numeral system where two successive values differ in only one bit.
	Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
	For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	00 - 0
	01 - 1
	11 - 3
	10 - 2
 * 
 * n位格雷码，是由n-1位格雷码转换成。一部分是n-1位格雷码，另一部分是1<<(n-1)和n-1位格雷码的逆序之和
 */
public class GrayCode {
	
	public List<Integer> grayCode(int n) {
		
		List<Integer> res = new ArrayList<>();
		if(n==0) {
			res.add(0);
			return res;
		}
		//n==1时
		res.add(0);
		res.add(1);
		for(int i=2;i<=n;i++) {
			int size = res.size();
			for(int j=size-1;j>=0;j--) {
				res.add((1<<(i-1))+res.get(j));
			}
		}
		return res;
	}
}
