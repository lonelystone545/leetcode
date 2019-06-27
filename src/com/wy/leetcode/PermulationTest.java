package com.wy.leetcode;

/*
 * 求全排列
 * 
 * 每一次循环中，都要将str[i]与str[i]互相调换位置：第一次开始，"a"与自己换，这时候，递归调用arrange[str,st + 1, len]
这是在求取str[str...len - 1]的排列即"b","c"的排列；
第二次，"a"与"b"互相调换，递归调用arrange[str,str + 1, len]就是在求取{"a","c"}的排列。
第三次，"a"与"c"互相调换，递归调用arrange[str, str + 1,len]就是在求取"{"b","a}的排列。
下面再以"b","c"的排列求取为例：
首先还是做循环，第一次，"b"与自己调换，这时候，调用arrange[str,st + 1,len], 就是求c的排列。呵呵，这时候终于到了函数递归调用的出口了
: st = len - 1。输出"b" "c";
第二次，类似的，输出"c","b";
至此，"b" "c"的排列求取完毕。加上前面的a,就输出"a""b""c" "a""c""b"。
类似的，就可以输出所有的排列了。
 */
public class PermulationTest {
	public static void main(String[] args) {
		String s = "aabb";
		permulation(s.toCharArray(),0);
	}
	
	public static void permulation(char[] chs,int start) {
		if(start==chs.length-1) {
			for(int i=0;i<chs.length;i++) {
				System.out.print(chs[i]);
			}
			System.out.println();
		} else {
			for(int i=start;i<chs.length;i++) { 
				//与后面非重复的数字交换  比如aabb，a(2)与b(3)交换之后，不应该b(4)进行交换了
				if(!isSwap(chs,start,i)) { //加上这行 可以去除重复元素的交换
					swap(chs,start,i); 
					permulation(chs,start+1);
					swap(chs,start,i);
				}
			}
		}
	}
	
	public static boolean isSwap(char[] chs,int start,int end) {
		for(int i=start;i<end;i++) {
			if(chs[i]==chs[end]) {
				return true;
			}
		}
		return false;
	}
	
	public static void swap(char[] chs,int i,int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}
	
}
