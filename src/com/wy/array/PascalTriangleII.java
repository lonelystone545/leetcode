package com.wy.array;

import java.util.ArrayList;
import java.util.List;

/*
 * 杨辉三角  打印rowIndex的数
 */
public class PascalTriangleII {
	//这里每到一行，都会有对应的数1了，所以可以直接从前向后遍历
	public List<Integer> getRow2(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		for(int i=0;i<=rowIndex;i++) {
			res.add(0, 1);
			for(int j=1;j<i;j++) {
				res.set(j, res.get(j)+res.get(j+1));
			}
		}
		return res;
	}
	//从后向前遍历
	public List<Integer> getRow(int rowNums) {
		List<Integer> res = new ArrayList<Integer>();
		//初始化第一个元素为1
		res.add(1);
		for(int i=0;i<rowNums;i++) {
			for(int j=res.size()-2;j>=0;j--) {
				res.set(j+1, res.get(j)+res.get(j+1));
			}
			//每行最后一个数为1
			res.add(1);
		}
		return res;
	}
}
