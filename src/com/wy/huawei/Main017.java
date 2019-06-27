package com.wy.huawei;

/*
 * ��������
 * 
 * ����ĵ� 1 �У�Ϊ��������������һ���ո������N m
 *������ N �� <32000 ����ʾ��Ǯ���� m �� <60 ��Ϊϣ��������Ʒ�ĸ�������
 *
 * �ӵ� 2 �е��� m+1 �У��� j �и����˱��Ϊ j-1 ����Ʒ�Ļ������ݣ�ÿ���� 3 ���Ǹ����� v p q
 *
 *������ v ��ʾ����Ʒ�ļ۸� v<10000 ���� p ��ʾ����Ʒ����Ҫ�ȣ� 1 ~ 5 ���� q ��ʾ����Ʒ���������Ǹ�����
 * ��� q=0 ����ʾ����ƷΪ��������� q>0 ����ʾ����ƷΪ������ q �����������ı�ţ�
 * 
 * 
 *  ����ļ�ֻ��һ����������Ϊ��������Ǯ������Ʒ�ļ۸�����Ҫ�ȳ˻����ܺ͵����ֵ�� <200000 ����
 */
import java.util.Scanner;

public class Main017 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// ��Ǯ��
			int n = sc.nextInt();
			// ��Ʒ����
			int m = sc.nextInt();
			int[] p = new int[m];
			int[] v = new int[m];
			int[] q = new int[m];
			for (int i = 0; i < m; i++) {
				// �۸�
				p[i] = sc.nextInt();
				// ��ֵ
				v[i] = sc.nextInt()*p[i];
				// ������
				q[i] = sc.nextInt();
			}
			System.out.println(getMaxValue(v, p, q, m, n));
		}
	}

	private static int getMaxValue(int[] v, int[] p, int[] q, int m, int n) {
		int[][] f = new int[m+1][n+1];
		for(int i=1;i<=m;i++) { //��Ʒ����
			for(int j=1;j<=n;j++){ //��Ǯ��
				if(q[i-1]==0) { //����
					if(p[i-1] <= j){
						f[i][j] = Math.max(f[i-1][j], f[i-1][j-p[i-1]]+v[i-1]);
					} 
				} else { //����
					if(p[i-1]+p[q[i-1]] <= j) {
						f[i][j] = Math.max(f[i-1][j], f[i-1][j-p[i-1]]+v[i-1]);
					}
				}
			}
		}
		return f[m][n];
	}
}
