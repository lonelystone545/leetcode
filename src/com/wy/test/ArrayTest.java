package com.wy.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayTest {
	//121. Best Time to Buy and Sell Stock
	public int test1(int[] prices) {
		if(prices==null || prices.length==0) return 0;
		int min = Integer.MAX_VALUE;
		int profit = 0;
		for(int i:prices) {
			min = (i<min)? i:min;
			profit = (i-min)>profit? (i-min):profit;
		}
		return profit;
	}
	//122. Best Time to Buy and Sell Stock II 
	public int test2(int[] prices) {
		if(prices==null || prices.length==0) {
			return 0;
		}
		//找到局部最低点和局部最高点
		int buy,sell;
		int i = 0;
		int total = 0;
		while(i<prices.length-1) {
			while(i+1<prices.length && prices[i+1]<prices[i]) {
				i++;
			}
			buy = i;
			i++;
			while(i<prices.length && prices[i]>prices[i-1]) {
				i++;
			}
			sell = i-1;
			total += prices[sell]-prices[buy];
		}
		return total;
	}
	//135. Candy 
	public int test3(int[] ratings) {
		if(ratings==null || ratings.length==0) {
			return 0; 
		}
		int[] left = new int[ratings.length];
		int[] right = new int[ratings.length];
		left[0]=1;
		for(int i=1;i<ratings.length;i++) {
			if(ratings[i]>ratings[i-1]) {
				left[i] = left[i-1]++;
			} else {
				left[i] = 1;
			}
		}
		right[ratings.length-1]=1;
		for(int i=ratings.length-2;i>=0;i--) {
			if(ratings[i]>ratings[i+1]) {
				right[i]=right[i+1]++;
			} else {
				right[i]=1;
			}
		}
		int sum = 0;
		for(int i=0;i<left.length;i++) {
			if(left[i]<right[i]) {
				sum+=right[i];
			} else {
				sum+=left[i];
			}
		}
		return sum;
	}
	
	//135. Candy 
	public int test4(int[] ratings) {
		if(ratings==null || ratings.length==0) return 0;
		int sum = 1;
		int count = 0;
		int pre = 1;
		for(int i=1;i<ratings.length;i++) {
			if(ratings[i]>=ratings[i-1]) {
				if(count>0) {
					sum += (1+count)*count/2;
					if(count>=pre) {
						sum += count-pre+1;
					}
					count = 0;
					pre=1;
				}
				pre = (ratings[i]==ratings[i-1])?1:pre+1;
				sum += pre;
			} else {
				count++;
			}
		}
		return sum;
	}
	
	//climb stairs
	public int test5(int n) {
		if(n<0) return -1;
		if(n==0) return 0;
		int llast = 1;
		int last = 2;
		int cur = 0;
		for(int i=3;i<=n;i++) {
			cur = llast+last;
			llast = last;
			last = cur;
		}
		return cur;
	}
	
	//217. Contains Duplicate
	public boolean test6(int[] arr) {
		if(arr==null || arr.length==0) return false;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(!set.add(arr[i])) { //如果添加的元素不存在，则返回true
				return true;
			}
		}
		return false;
	}
	
	//219. Contains Duplicate II
	public boolean test7(int[] nums,int k) {
		if(nums==null || nums.length==0 || k<=0) {
			return false;
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				int diff = i-map.get(nums[i]);
				if(diff<k) {
					return true;
				} else {
					map.put(nums[i], i);
				}
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}
	
	public static List<Integer> test8(int[] nums) {
		if(nums==null || nums.length==0) return null;
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=i+1) {
				if(nums[nums[i]-1]!=nums[i]) {
					int tmp = nums[i];
					nums[i] = nums[nums[i]-1];
					nums[tmp-1] = tmp;
					i--;
				}
			}
		}
		for(int i:nums) {
			System.out.println(i);
		}
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=(i+1)) {
				res.add(i+1);
			}
		}
		return res;
	}
	public List<Integer> test9(int[] nums) {
		if(nums==null || nums.length==0) return null;
		int len = nums.length;
		List<Integer> res = new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			nums[(nums[i]-1)%len] += len;
		}
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<len) {
				res.add(len);
			}
		}
		return res;
	}
	
	//453 4Sum
	public List<List<Integer>> test10(int[] nums,int target) {
		if(nums==null | nums.length<4) return null;
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length-3;i++) {
			if(i>0 && nums[i]==nums[i-1]) continue;
			for(int j=i+1;j<nums.length-2;j++) {
				if(j>i+1 && nums[j]==nums[j-1]) continue;
				int top = j+1;
				int tail = nums.length-1;
				while(top<tail) {
					if(nums[i]+nums[j]+nums[top]+nums[tail]==target) {
						List<Integer> res1 = new ArrayList<>();
						res1.add(nums[i]);
						res1.add(nums[j]);
						res1.add(nums[top]);
						res1.add(nums[tail]);
						res.add(res1);
						while(top<tail && nums[top]==nums[top+1]) top++;
						while(top<tail && nums[tail]==nums[tail-1]) tail--;
						top ++;
						tail --;
					} else if(nums[i]+nums[j]+nums[top]+nums[tail]>target) {
						tail --;
					} else {
						top++;
					}
				}
			}
		}
		return res;
	}
	
	//454. 4Sum II 
	public int test11(int[] a,int[] b,int[] c,int[] d) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				map.put(a[i]+b[j], map.getOrDefault(a[i]+b[j], 0)+1);
			}
		}
		int res = 0;
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<d.length;j++) {
				if(map.containsKey(-(c[i]+d[j]))) {
					res += map.get(-(c[i]+d[j]));
				}
			}
		}
		return res;
	}
	
	public int  test12(int[] gas,int[] cos) {
		if(gas==null || cos==null) return -1;
		int sum = 0;
		int total = 0;
		int start = 0;
		for(int i=0;i<gas.length;i++) {
			sum += (gas[i]-cos[i]);
			total += (gas[i]-cos[i]);
			if(sum<0) {
				sum = 0;
				start = i+1;
			}
		}
		if(total<0) {
			return -1;
		} else {
			return start;
		}
	}
	
	//gray code
	public List<Integer> test13(int n) {
		if(n<=0) return null;
		List<Integer> res = new ArrayList<Integer>();
		res.add(0);
		res.add(1);
		if(n==1) return res;
		for(int i=2;i<=n;i++) {
			int size = res.size();
			for(int j=size-1;j>=0;j--) {
				res.add((1<<(i-1))+res.get(j));
			}
		}
		return res;
	}
	
	//K-diff Pairs in an Array
	public int test14(int[] nums,int k) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		Arrays.sort(nums);
		int i = 0;
		int j = 1;
		int count = 0;
		while(j<nums.length) {
			if(nums[j]-nums[i]==k) {
				count++;
				while(i+1<nums.length && nums[i]==nums[i+1]) {
					i++;
				}
				while(j+1<nums.length && nums[j]==nums[j-1]) {
					j++;
				}
				i++;
				j++;
			} else if(nums[j]-nums[i]<k) {
				j++;
			} else {
				i++;
			}
			if(i==j) j++;
		}
		return count;
	}
	
	//128. Longest Consecutive Sequence
	public int test15(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int res = 0;
		for(int i : nums) {
			if(!map.containsKey(i)){
				int left = map.getOrDefault(i-1, 0);
				int right = map.getOrDefault(i+1, 0);
				map.put(i, left+right+1);
				res = Math.max(res, left+right+1);
				map.put(i-left, left+right+1);
				map.put(i+left, left+right+1);
			} else {
				continue;
			}
		}
		return res;
	}
	
	//169. Majority Element
	public int test16(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int count = 0;
		int major = 0;
		for(int n : nums) {
			if(count==0) {
				major = n;
				count++;
			} else if(n != major) {
				count --;
			} else {
				count ++;
			}
		}
		return major;
	}
	
	public int test17(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int count = 0;
		int res = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==1) {
				count ++;
			} else {
				res = Math.max(res, count);
				count = 0;
			}
		}
		return res;
	}
	
	//leetcode53~Maximum Subarray
	public static int test18(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int sum = 0;
		int max = 0;
		int start = 0;
		int end = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>=nums[i]+sum) {
				start = i;
				sum = nums[i];
			} else {
				sum = nums[i]+sum;
			}
			if(sum>=max) {
				end = i;
				max = sum;
			} else {
				max = max;
			}
			max = Math.max(max, sum);
		}
		System.out.println(start);
		System.out.println(end);
		System.out.println(max);
		return max;
	}
	
	public double test19(int[] a,int[] b) {
		int m = a.length;
		int n = b.length;
		int total = m + n;
		if(total%2==1){
			return findKth(a,0,m-1,b,0,n-1,total/2+1);
		} else {
			double x = findKth(a,0,m-1,b,0,n-1,total/2);
			double y = findKth(a,0,m-1,b,0,n-1,total/2+1);
			return (x+y)/2;
		}
	}
	
	private int findKth(int[] a, int astart, int aend, int[] b, int bstart, int bend, int k) {
		int m = aend-astart+1;
		int n = bend-bstart+1;
		if(m>n) {
			findKth(b,bstart,bend,a,astart,aend,k);
		}
		if(m==0) {
			return b[k-1];
		}
		if(k==1) {
			return Math.min(a[astart], b[bstart]);
		}
		int partA = Math.min(k/2, m);
		int partB = k-partA;
		if(a[astart+partA-1]==b[bstart+partB-1]) {
			return a[astart+partA-1];
		} else if(a[astart+partA-1]>b[bstart+partB-1]) {
			return findKth(a,astart,aend,b,bstart+partB,bend,k-partB);
		} else {
			return findKth(a,astart+partA,aend,b,bstart,bend,k-partA);
		}
	}
	
	//mising number
	public int test19(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int res = 0;
		for(int i=0;i<nums.length;i++) {
			res ^= i;
			res ^= nums[i];
		}
		return res;
	}
	
	//mova zeroes
	public void test20(int[] nums) {
		if(nums==null || nums.length ==0) return;
		int i = 0;
		for(int j=0;j<nums.length;j++) {
			if(nums[j]!=0) {
				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
				i++;
			} else {
				continue;
			}
		}
	}
	
	//nextpermutation
	public void test21(int[] nums) {
		if(nums==null || nums.length==0 || nums.length==1) return;
		int j = -1;
		for(int i=nums.length-1;i>=1;i--) {
			if(nums[i]>nums[i-1]) {
				j = i-1; //记录下第一个非增的数的下标
				break;
			}
		}
		if(j==-1) {
			reverse(nums,0,nums.length-1);
			return;
		}
		
		int min = nums[j];
		int jj = j+1;
		for(int i=nums.length-1;i>j;i--) {
			if(nums[i]>min) {
				jj = i;
				break;
			}
		}
		swap(nums,j,jj);
		reverse(nums,j+1,nums.length-1);
		
	}
	
	public List<List<Integer>> test22(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			list.add(0,1);
			for(int j=1;j<i;j++) {
				list.set(j, list.get(j)+list.get(j+1));
			}
			res.add(new ArrayList<>(list));
		}
		return res;
	}
	
	//60. Permutation Sequence 
	public String test23(int n,int k) {
		
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		int sum = 1;
		int[] fac = new int[n+1];
		fac[0]=1;
		for(int i=1;i<n+1;i++) {
			sum = sum*i;
			fac[i] = sum;
		}
		
		k = k-1;
		for(int i=1;i<n+1;i++) {
			int index = k/fac[n-i];
			sb.append(String.valueOf(list.get(index)));
			list.remove(index);
			k = k - index*fac[n-i];
		}
		return sb.toString();
	}
	
	private void reverse(int[] nums, int i, int j) {
		while(i<j) {
			swap(nums,i,j);
			i++;
			j--;
		}
	}
	private void swap(int[] nums, int j, int jj) {
		int tmp = nums[j];
		nums[j] = nums[jj];
		nums[jj] = tmp;
	}
	
	//plus One
	public int[] test24(int[] digits) {
		if(digits.length==0 || digits==null) {
			return null;
		}
		for(int i=digits.length-1;i>=0;i--) {
			if(digits[i]<9) {
				digits[i]++;
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		int[] news = new int[digits.length];
		news[0] = 1;
		return digits;
	}
	
	//remove duplicates from sorted array
	public int test25(int[] arr) {
		if(arr==null || arr.length==0) return 0;
		int j = 1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]!=arr[i-1]) {
				arr[j++] = arr[i];
			}
		}
		return j;
	}
	
	//remove duplicates from sorted array II
	public static int test26(int[] arr) {
		if(arr==null || arr.length==0) return 0;
		int index = 1;
		int k = 0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i] != arr[i-1]) {
				arr[index++] = arr[i];
				k = 0;
			} else if(arr[i]==arr[i-1] && k==0) {
				arr[index++] = arr[i];
				k++;
			}
		}
		return index;
	}
	
	//remove element
	public static int test27(int[] nums,int val) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		int index = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=val) {
				nums[index++] = nums[i];
			}
		}
		return index;
	}
	
	//rotate array
	public void test28(int[] nums,int k) {
		if(nums==null || nums.length==0) {
			return;
		}
		k = k % nums.length;
		reverse(nums,0,nums.length-k-1);
		reverse(nums,nums.length-k,nums.length-1);
		reverse(nums,0,nums.length-1);
	}
	
	//rotate image
	public void test29(int[][] matrix) {
		if(matrix==null || matrix.length==0) return;
		//上下对称交换
		for(int i=0;i<matrix.length/2;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length-1-i][j];
				matrix[matrix.length-1-i][j] = tmp;
			}
		}
		//沿主对角线交换
		for(int i=0;i<matrix.length-1;i++) {
			for(int j=i+1;j<matrix.length;j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
	
	//33 search in rotated sorted array with no duplicates
	public int test30(int[] nums,int target) {
		if(nums==null || nums.length==0) return -1;
		int start = 0;
		int end = nums.length-1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(nums[mid]==target) {
				return mid;
			} else if(nums[start]<=nums[mid]) { //左边有序
				if(nums[start]<=target && target<nums[mid]) {
					end = mid-1;
				} else {
					start = mid+1;
				}
			} else { //右边有序
				if(nums[mid]<target && target<=nums[end]) {
					start = mid+1;
				} else {
					end = mid-1;
				}
			}
		}
		return -1;
	}
	
	//search in rotate sorted array with duplicates
	public boolean test31(int[] nums,int target) {
		if(nums==null || nums.length==0) {
			return false;
		}
		int start = 0;
		int end = nums.length-1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(nums[mid]==target) {
				return true;
			}
			if(nums[start]<nums[mid]) {
				if(nums[start]>target && target<nums[end]) {
					end = mid-1;
				} else {
					start = mid+1;
				}
			} else if(nums[start]>nums[mid]) { //右边有序
				if(nums[mid]<target && target<nums[end]) {
					start = mid+1;
				} else {
					end = mid-1;
				}
			} else {
				start ++;
			}
		}
		return false;
	}
	
	public int test32(int[] nums,int target) {
		if(nums==null || nums.length==0) {
			return -1;
		}
		for(int i=nums.length-1;i>=0;i--) {
			if(nums[i]>target) {
				continue;
			} else if(nums[i]<target){
				return i+1; 
			} else {
				return i;
			}
		}
		return 0;
	}
	
	//set matrix zero
	public void test33(int[][] matrix) {
		if(matrix==null || matrix.length==0) {
			return;
		}
		boolean rowHasZero = false;
		boolean colHasZero = false;
		for(int i=0;i<matrix[0].length;i++) {
			if(matrix[0][i] == 0) {
				rowHasZero = true;
				break;
			}
		}
		for(int i=0;i<matrix.length;i++) {
			if(matrix[i][0]==0) {
				colHasZero = true;
				break;
			}
		}
		
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[0].length;j++) {
				if(matrix[i][j]==0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[0].length;j++) {
				if(matrix[0][j]==0 || matrix[i][0]==0) {
					matrix[i][j] = 0;
				}
			}
		}
		if(rowHasZero) {
			for(int i=0;i<matrix[0].length;i++) {
				matrix[0][i] = 0;
			}
		}
		if(colHasZero) {
			for(int i=0;i<matrix.length;i++) {
				matrix[i][0] = 0;
			}
		}
	}
	
	//find single number
	public int test34(int[] nums) {
		if(nums==null || nums.length==0) {
			return -1;
		}
		int number = 0;
		for(int i=0;i<nums.length;i++) {
			number = number ^ nums[i];
		}
		return number;
	}
	
	//find single number II
	public int test35(int[] nums) {
		if(nums==null || nums.length==0) return -1;
		int[] count = new int[32];
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<count.length;j++) {
				if(((nums[i]>>j) & 1) == 1){
					count[j] ++;
				}
			}
		}
		int res = 0;
		for(int i=0;i<count.length;i++) {
			res = (count[i]%3)<<i + res;
		}
		return res;
	}
	
	//third max num
	public int test36(int[] nums) {
		if(nums==null || nums.length==0) return -1;
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int thirdMax = Integer.MIN_VALUE;
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>firstMax) {
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = nums[i];
			} else if(nums[i]>secondMax && nums[i]<firstMax) {
				thirdMax = secondMax;
				secondMax = nums[i];
			} else if(nums[i]>thirdMax && nums[i]<secondMax) {
				thirdMax = nums[i];
			}
		}
		if(thirdMax==Integer.MIN_VALUE) {
			return firstMax;
		} else {
			return thirdMax;
		}
	}
	
	//3 sum
	public List<List<Integer>> test37(int[] nums) {
		if(nums==null || nums.length<3) return null;
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++) {
			if(i>0 && nums[i]==nums[i-1]) continue;
			int start = i+1;
			int end = nums.length-1;
			while(start<end) {
				if(nums[start]+nums[end]+nums[i]==0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[start]);
					list.add(nums[end]);
					res.add(list);
					while(start<end && nums[start]==nums[start+1]) start++;
					while(start<end && nums[end]==nums[end-1]) end--;
					start++;
					end--;
				} else if(nums[start]+nums[end]+nums[i]>0) {
					end--;
				} else {
					start++;
				}
			}
		}
		return res;
	}
	
	//3 sum closest number
	public int test38(int[] nums,int target) {
		if(nums==null || nums.length<3) return -1;
		Arrays.sort(nums);
		int dif = Integer.MAX_VALUE;
		int res = 0;
		for(int i=0;i<nums.length-2;i++) {
			if(i!=0 && nums[i]!=nums[i-1]) continue;
			int start = i+1;
			int end = nums.length-1;
			while(start<end) {
				int sum = nums[i]+nums[start]+nums[end];
				if(sum>target) {
					if(sum-target<dif) {
						dif = sum-target;
						res = sum;
					}
					while(start<end && nums[end]==nums[end-1]) end--;
				} else if(sum<target) {
					if(target-sum<dif) {
						dif = target-sum;
						res = sum;
					}
					while(start<end && nums[start]==nums[start++]) start++;
				} else {
					return sum;
				}
			}
		}
		return res;
	}
	
	//trap rain water
	public int test39(int[] nums) {
		if(nums==null || nums.length<3) return 0;
		int[] lefts = new int[nums.length];
		int[] rights = new int[nums.length];
		int max = lefts[0];
		lefts[0] = nums[0];
		for(int i=1;i<nums.length;i++) {
			lefts[i] = Math.max(max, nums[i]);
			max = Math.max(max, nums[i]);
		}
		max = rights[rights.length-1];
		rights[rights.length-1] = nums[nums.length-1];
		for(int i=nums.length-2;i>=0;i--) {
			rights[i] = Math.max(max, nums[i]);
			max = Math.max(max, nums[i]);
		}
		
		int res = 0;
		int sum = 0;
		//第一个和最后一个不能装水
		for(int i=1;i<nums.length-1;i++) {
			sum = Math.min(lefts[i], rights[i]) - nums[i];
			res = res + sum; 
		}
		return res;
	}
	
	public boolean test40(char[][] board) {
		if(board==null || board.length==0) return false;
		Set<Character> set = new HashSet<Character>();
		//对行检查
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]>'1' && board[i][j]<'9') {
					if(!set.add(board[i][j])) {
						return false;
					}
				}
			}
			set.clear();
		}
		//对列检查
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[j][i]>'1' && board[j][i]<'9') {
					if(!set.add(board[j][i])) {
						return false;
					}
				}
			}
			set.clear();
		}
		//对小的九宫格检查
		for(int i=0;i<board.length;i+=3) {
			for(int j=0;j<board.length;j+=3) {
				for(int m=i;m<i+3;m++) {
					for(int n=j;n<j+3;n++) {
						if(board[m][n]>'1' && board[m][n]<'9') {
							if(!set.add(board[m][n])) {
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
	
	public static void main(String[] args) {
		int[] arr = {3,2,2,3};
		int num = test27(arr,3);
		System.out.println(num);
	}
}
