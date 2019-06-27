package com.wy.array;

import java.util.HashSet;
import java.util.Set;

/*
 * 36. Valid Sudoku 
 * 检验九宫格
 */
public class ValidSudoku {
	
	//set集合用于存放元素值，进行重复性检查
	public boolean isValidSudoku2(char[][] board) {
        Set<Character> set = new HashSet<Character>();
        //按行检验
        for(int i=0;i<9;i++) {
        	for(int j=0;j<9;j++) {
        		if(board[i][j]>='1' && board[i][j]<='9') {
        			if(!set.add(board[i][j])) {
        				return false;
        			}
        		}
        	}
        	set.clear();
        }
        //按列检验
        for(int i=0;i<9;i++) {
        	for(int j=0;j<9;j++) {
        		if(board[j][i]>='1' && board[j][i]<='9') {
        			if(!set.add(board[j][i])) {
        				return false;
        			}
        		}
        	}
        	set.clear();
        }
      //按小的九宫格检验
       for(int i=0;i<9;i+=3) {
    	   for(int j=0;j<9;j+=3) {
    		   for(int row=i;row<i+3;row++) {
    			   for(int column=j;column<j+3;column++) {
    				   if(board[row][column]>='1' && board[row][column]<='9') {
    	        			if(!set.add(board[row][column])) {
    	        				return false;
    	        			}
    	        		}
    			   }
    		   }
    		   set.clear();
    	   }
       }
       return true;
    }
	
	
	public boolean isValidSudoku(char[][] board) {
		Set<Character> rows = new HashSet<>();
		Set<Character> columns = new HashSet<>();
		Set<Character> cubes = new HashSet<>();
		
		for(int i=0;i<9;i++) {
			rows.clear();
			columns.clear();
			cubes.clear();
			for(int j=0;j<9;j++) {
				//行检查
				if(board[i][j]!='.' && !rows.add(board[i][j])) {
					return false;
				}
				//列检查
				if(board[j][i]!='.' && !columns.add(board[j][i])) {
					return false;
				}
				//小的九宫格检查
				int r = (i/3)*3;
				int c = (i%3)*3;
				if(board[r+j/3][c+j%3]!='.' && !cubes.add(board[r+j/3][c+j%3])) {
					return false;
				}
			}
		}
		return true;
	}
}
