package com.wy.array;

import java.util.HashSet;
import java.util.Set;

/*
 * 36. Valid Sudoku 
 * ����Ź���
 */
public class ValidSudoku {
	
	//set�������ڴ��Ԫ��ֵ�������ظ��Լ��
	public boolean isValidSudoku2(char[][] board) {
        Set<Character> set = new HashSet<Character>();
        //���м���
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
        //���м���
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
      //��С�ľŹ������
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
				//�м��
				if(board[i][j]!='.' && !rows.add(board[i][j])) {
					return false;
				}
				//�м��
				if(board[j][i]!='.' && !columns.add(board[j][i])) {
					return false;
				}
				//С�ľŹ�����
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
