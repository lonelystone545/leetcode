package com.wy.huawei;

/*
 * 背包问题
 * 
 * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 *（其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 *
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 *
 *（其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。
 * 如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 * 
 * 
 *  输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
 */
import java.util.Scanner;

public class Main017 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// 总钱数
			int n = sc.nextInt();
			// 商品个数
			int m = sc.nextInt();
			int[] p = new int[m];
			int[] v = new int[m];
			int[] q = new int[m];
			for (int i = 0; i < m; i++) {
				// 价格
				p[i] = sc.nextInt();
				// 价值
				v[i] = sc.nextInt()*p[i];
				// 主附件
				q[i] = sc.nextInt();
			}
			System.out.println(getMaxValue(v, p, q, m, n));
		}
	}

	private static int getMaxValue(int[] v, int[] p, int[] q, int m, int n) {
		int[][] f = new int[m+1][n+1];
		for(int i=1;i<=m;i++) { //商品个数
			for(int j=1;j<=n;j++){ //总钱数
				if(q[i-1]==0) { //主件
					if(p[i-1] <= j){
						f[i][j] = Math.max(f[i-1][j], f[i-1][j-p[i-1]]+v[i-1]);
					} 
				} else { //附件
					if(p[i-1]+p[q[i-1]] <= j) {
						f[i][j] = Math.max(f[i-1][j], f[i-1][j-p[i-1]]+v[i-1]);
					}
				}
			}
		}
		return f[m][n];
	}
}
