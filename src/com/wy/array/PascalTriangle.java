package com.wy.array;

import java.util.ArrayList;
import java.util.List;
/*
 * 杨辉三角
 */
public class PascalTriangle {
	
	public List<List<Integer>> generate(int rowNums) {
		//使用集合（与一维数组实现有相似）
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> row = new ArrayList<>();
		for(int i=0;i<rowNums;i++) {
			row.add(0, 1);
			for(int j=1;j<i;j++) {
				row.set(j, row.get(j)+row.get(j+1));
			}
			//这里重更新建立新的集合，防止覆盖
			res.add(new ArrayList<>(row));
		}
		return res;
	}
	
	//使用二维数组
	public List<List<Integer>> generate2(int rowNums) {
		List<List<Integer>> res = new ArrayList<>();
		if(rowNums==0) return res;
		
		int[][] arr = new int[rowNums][rowNums];
		//初始化
		for(int i=0;i<rowNums;i++) {
			arr[i][0]=1;
			arr[i][i]=1;
		}
		
		for(int i=2;i<rowNums;i++) {
			for(int j=1;j<i;j++) {
				arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
			}
		}
		for(int i=0;i<arr.length;i++) {
			List<Integer> list = new ArrayList<>();
			for(int j=0;j<=i;j++) {
				list.add(arr[i][j]);
			}
			res.add(list);
		}
		return res;
	}
}
