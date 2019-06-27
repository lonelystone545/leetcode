package com.wy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 *  128. Longest Consecutive Sequence 
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence. 
	For example,
	Given [100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4. 
	Your algorithm should run in O(n) complexity. 
	
	
	如果对时间复杂度没有要求，可以先排序，再找连续的数。
	但是要求O(n)，就不能使用排序了。
	由于序列是无序的，又要求O(n)，应该想到哈希表或者集合。
 */
public class LongestConsecutiveSequence {
	
	/*
	 * 使用map集合，键存储元素，值存储对应的连续长度
	 * 当连续长度发生变化时，要对应的更新到首尾键的值
	 * 因为下次进行判断取出时，是根据首尾进行的，中间的值无所谓
	 * 如{1,2,3} map.get(1)和map.get(3)返回的都是3
	 */
	public int longestConsecutive2(int[] nums) {
		int res = 0;//记录最大长度
		Map<Integer,Integer> map = new HashMap<>();
		for(int n: nums) {
			if(!map.containsKey(n)) {
				//如果包含左(右)值，则取出对应的值(连续长度)
				int left = (map.containsKey(n-1))? map.get(n-1):0;
				int right = (map.containsKey(n+1))? map.get(n+1):0;
				// 加上本身的数'1'
				int sum = left+right+1;
				//存入数据及对应的连续长度
				map.put(n,sum);
				res = Math.max(res, sum);
				
				//目的是更新连续长度的头和尾的值
				map.put(n-left, sum);
				map.put(n+right, sum);
				
			} else {
				//如果已经包含了该值，则跳过该次循环
				continue;
			}
		}
		return res;
	}
	
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		//将数组中的元素加入到集合中
		for(int n:nums) {
			set.add(n);
		}
		int length = 0;
		//遍历数组
		for(int n :nums) {
			if(set.contains(n)) {
				int count = 1;
				//将元素n删除
				set.remove(n);
				
				int left = n-1;
				while(set.contains(left)){
					count++;
					set.remove(left);
					left--;
				}
				int right = n+1;
				while(set.contains(right)){
					count++;
					set.remove(right);
					right++;
				}
				length = Math.max(length, count);
			}
		}
		return length;
	}
}
