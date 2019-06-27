package com.wy.array;

/*
 *  You are climbing a stair case. It takes n steps to reach to the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
	Note: Given n will be a positive integer. 
 * 
 * 爬到第n层要么从n-1层要么从n-2层上来的。故有dp[n]=dp[n-1]+dp[n-2]
 * 初始:dp[0]=0;dp[1]=1;dp[2]=2
 * 
 * 斐波那契数列
 */
public class ClimbingStairs {
	
	//申请一个数组，记录每次步数对应的方式种数
	public int climbStairs(int n) {
		
		if(n==0 || n==1 || n==2) return n;
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3;i<=n;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
	//申请三个变量记录
	public int climbStairs2(int n) {
		if(n==0||n==1||n==2) return n;
		
		int last=2,lastlast=1;
		int cur=0;
		for(int i=3;i<=n;i++) {
			cur = last+lastlast;
			lastlast = last;
			last =cur;
		}
		return cur;
	}
	
	//这是一个斐波那契数列，有对应的公式
	public int climbStairs3(int n) {
		double s = Math.sqrt(5);
		return  (int) Math.floor((Math.pow((1+s)/2, n+1) + Math.pow((1-s)/2, n+1))/s + 0.5);
	}
}