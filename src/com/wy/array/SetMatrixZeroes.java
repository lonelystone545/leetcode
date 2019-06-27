package com.wy.array;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place. 
 */
public class SetMatrixZeroes {
	
	//使用set集合存储
	public void setZeroes2(int[][] matrix) {
        
		if(matrix==null || matrix.length==0) return;
		Set<Integer> rset = new HashSet<>();
		Set<Integer> cset = new HashSet<>();
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(matrix[i][j]==0) {
					rset.add(i);
					cset.add(j);
				}
			}
		}
		for(int r :rset) {
			for(int j=0;j<matrix.length;j++) {
				matrix[r][j]=0;
			}
		}
		for(int c :cset) {
			for(int i=0;i<matrix[0].length;i++) {
				matrix[i][c]=0;
			}
		}
		
    }
	
	//使用数组存储 记录每行每列是否存在0
	public void setZeroes3(int[][] matrix) {
		
		int m = matrix.length;
		int n = matrix[0].length;
		if(m==0 || n==0) {
			return;
		}
		int[] rflag = new int[m];
		int[] cflag = new int[n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(matrix[i][j]==0) {
					//对应到具体元素
					rflag[i]=1;
					cflag[j]=1;
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(rflag[i]==1 || cflag[j]==1) {
					matrix[i][j]=0;
				}
			}
		}
	}
	
	//常数空间，复用第一行和第一列
	public void setZeroes(int[][] matrix) {
		
		int rnum = matrix.length;
		int cnum = matrix[0].length;
		//第一行和第一列是否有0
		boolean rf = false;
		boolean cf = false;
		
		for(int i=0;i<cnum;i++) {
			if(matrix[0][i]==0) {
				rf=true;
				break;
			}
		}
		for(int i=0;i<rnum;i++) {
			if(matrix[i][0]==0) {
				cf = true;
				break;
			}
		}
		
		for(int i=0;i<rnum;i++) {
			for(int j=0;j<cnum;j++) {
				if(matrix[i][j]==0) {
					//对应的第一行和第一列该位置上的数设0
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		
		for(int i=1;i<rnum;i++) {
			for(int j=1;j<cnum;j++) {
				if(matrix[i][0]==0 || matrix[0][j]==0) {
					matrix[i][j]=0;
				}
			}
		}
		
		//第一行有0
		if(rf) {
			for(int i=0;i<cnum;i++) {
				matrix[0][i] = 0;
			}
		}
		//第一列有0
		if(cf) {
			for(int i=0;i<rnum;i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
