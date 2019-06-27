package com.wy.leetcode;

import java.util.Stack;

/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally 
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 *  11000
	11000
	00100
	00011
	Answer: 3
 */
public class NumIslands {
	//递归
	public int numIslands(char[][] grid) {
		int count = 0;
        for(int i=0;i<grid.length;i++) {
        	for(int j=0;j<grid[0].length;j++) {
        		if(grid[i][j]=='1') {
        			search(grid,i,j);
        			count++;
        		}
        	}
        }
        return count;
    }
	public void search(char[][] grid,int i,int j) {
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!='1') {
			return;
		}
		grid[i][j]='0';  //将遍历到的点标记为0  如果不希望改动原有矩阵的值，可以再新建一个矩阵，用于保存矩阵中每个元素对应的状态
		search(grid,i-1,j);
		search(grid,i+1,j);
		search(grid,i,j-1);
		search(grid,i,j+1);
	}
	
	public int numIslands2(char[][] grid) {
		if(grid==null || grid.length==0) return 0;
		int count = 0;
		int[][] isVisited = new int[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]=='1' && isVisited[i][j]==0) {//是陆地且没有被访问过
					search2(grid,isVisited,i,j);
					count++;
				}
			}
		}
		return count;
	}
	
	public void search2(char[][] grid,int[][] isVisited,int i,int j) {
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0' || isVisited[i][j]==1) {
			return;
		}
		isVisited[i][j]=1; 
		search2(grid,isVisited,i-1,j);
		search2(grid,isVisited,i+1,j);
		search2(grid,isVisited,i,j-1);
		search2(grid,isVisited,i,j+1);
	}
	
	//非递归解法   广搜（队列）或者深搜 （栈）
	public int numIslands3(char[][] grid) {
		Stack<Node> stack = new Stack<Node>();
		int count = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]=='1') {
					stack.push(new Node(i,j));
					count++; //累计加1
					while(!stack.isEmpty()) { //栈非空
						Node node = stack.pop();
						int x = node.x;
						int y = node.y;
						grid[x][y] = 0;
						if(x-1>=0 && grid[x-1][y]=='1') {
							stack.push(new Node(x-1,y));
						}
						if(x+1<grid.length && grid[x+1][y]=='1') {
							stack.push(new Node(x+1,y));
						}
						if(y-1>=0 && grid[x][y-1]=='1') {
							stack.push(new Node(x,y-1));
						}
						if(y+1<grid[0].length && grid[x][y+1]=='1') {
							stack.push(new Node(x,y+1));
						}
					}
				}
			}
		}
		return count;
	}
	
	class Node {
		private int x;
		private int y;
		public Node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
