package com.wy.huawei;

public class test {
		public static void main(String[] args) {
			System.out.println(binaryString(11));
		}
		private static String binaryString(int n) {
			StringBuilder sb = new StringBuilder();
			int flag = 1 << 7;
			for(int i=0; i<8; i++) {
				int val = (flag & n )== 0 ? 0 : 1;
				sb.append(val);
				n <<=1;
			}
			return sb.toString();
		}
}
