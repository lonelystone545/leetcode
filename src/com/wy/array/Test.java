package com.wy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
	
	public int test1(int[] prices) {
		if(prices == null || prices.length == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int profit = 0;
		for(int i : prices) {
			min = Math.min(min, i);
			profit = Math.max(i-min, profit);
		}
		return profit;
	}
	
	public int test2(int[] prices) {
		if(prices==null || prices.length==0) {
			return 0;
		}
		int i = 0;
		int profit = 0;
		int buy,sell;
		while(i<prices.length) {
			while(i+1<prices.length && prices[i+1]>prices[i]) {
				i++;
			}
			buy = i;
			i++;
			while(i<prices.length && prices[i]>=prices[i-1]) {
				i++;
			}
			sell = i-1;
			i++;
			profit = profit + (prices[sell]-prices[buy]);
		}
		return profit;
	}
	
	public int test3(int[] ratings) {
		if(ratings == null || ratings.length==0) {
			return 0;
		}
		int[] left = new int[ratings.length];
		int[] right = new int[ratings.length];
		
		left[0] = 1;
		for(int i=1;i<ratings.length;i++) {
			if(ratings[i]>ratings[i-1]) {
				left[i] = left[i-1] + 1;
			} else {
				left[i] = 1;
			}
		}
		right[ratings.length-1] = 1;
		for(int i=ratings.length-2;i>=0;i--) {
			if(ratings[i]>ratings[i+1]) {
				right[i] = right[i+1] + 1;
			} else {
				right[i] = 1;
			}
		}
		int sum = 0;
		for(int i=0;i<ratings.length;i++) {
			sum += Math.max(left[i], right[i]);
		}
		return sum;
	}
	
	public int test33(int[] ratings) {
		if(ratings==null || ratings.length==0) {
			return 0;
		}
		int pre = 1;
		//递减序列的长度
		int count = 0;
		int sum = 1;
		for(int i=1;i<ratings.length;i++){
			if(ratings[i]>=ratings[i+1]) {
				if(count>0) {
					sum += (1+count)*count/2;
					if(count>=pre) {
						sum += count-pre+1;
					}
					count = 0;
					pre = 1;
				}
				pre = ratings[i]==ratings[i+1]?1:pre+1;
				sum += pre;
			}else {
				count ++;
			}
		} 
		
		if(count>0) {
			sum += (1+count)*count/2;
		} else {
			if(count>=pre) {
				sum += count-pre+1;
			}
		}
		return sum;
	}
	
	public int test4(int n) {
		if(n==0) {
			return 0;
		} else if(n==1) {
			return 1;
		} else if(n==2) {
			return 2;
		} else {
			return test4(n-1)+test4(n-2);
		}
	}
	public int test44(int n) {
		if(n==0 || n==1 || n==2) {
			return n;
		}
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<n+1;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
	public boolean test5(int[] arr,int k) {
		if(arr==null || arr.length==0) {
			return false;
		}
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				if((i-map.get(arr[i]))<k) {
					return true;
				} else {
					map.put(arr[i], i);
				}
			}
		}
		return false;
	}
	public boolean test55(int[] arr,int k) {
		if(arr==null || arr.length==0) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			if(i>k) {
				set.remove(arr[i-k-1]);
			}
			if(!set.add(arr[i])) {
				return true;
			}
		}
		return false;
	}
	
	public List<Integer> test6(int[] arr) {
		if(arr==null || arr.length==0) {
			return null;
		}
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++) {
			arr[(arr[i]-1)%arr.length] += arr.length;
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<=arr.length) {
				res.add(i+1);
			}
		}
		return res;
	}
	
	public List<List<Integer>> test7(int[] arr,int target) {
		if(arr == null || arr.length<4) {
			return null;
		}
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(arr);
		for(int i=0;i<arr.length-3;i++) {
			if(i>0 && arr[i]==arr[i-1]) {
				continue;
			}
			for(int j=i+1;j<arr.length-2;j++) {
				if(j>i+1 && arr[j]==arr[j-1]) {
					continue;
				}
				int top = j+1;
				int tail = arr.length-1;
				while(top<tail) {
					if(arr[i]+arr[j]+arr[top]+arr[tail]==target) {
						List<Integer> list = new ArrayList<>();
						list.add(arr[i]);
						list.add(arr[j]);
						list.add(arr[top]);
						list.add(arr[tail]);
						res.add(list);
						while(top<tail && arr[top]==arr[top+1]) {
							top++;
						}
						while(top<tail && arr[tail]==arr[tail-1]) {
							tail--;
						}
					} else if(arr[i]+arr[j]+arr[top]+arr[tail]<target) {
						top++;
					} else {
						tail--;
					}
					
				}
			}
		}
		return res;
	}
	
	public int test8(int[] a,int[] b,int[] c,int[] d) {
		//a+b
		Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
		for(int i:a) {
			for(int j:b) {
				map1.put(i+j,map1.getOrDefault(i+j, 0)+1);
			}
		}
		
		int res = 0;
		for(int i:c) {
			for(int j:d) {
				if(map1.containsKey(-i-j)) {
					res += map1.get(-i-j);
				}
			}
		}
		return res;
	}
	
	public int test9(int[] gas,int[] cost) {
		if(gas==null || gas.length==0 || cost==null || cost.length==0) {
			return -1;
		}
		int start = -1;
		int sum = 0;
		int total = 0;
		for(int i=0;i<gas.length;i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			
			if(sum<0) {
				start = i;
				sum = 0;
			}
		}
		if(total<0) {
			return -1;
		} else {
			return start+1;
		}
	}
	
	public List<Integer> test10(int n) {
		if(n<=0) {
			return null;
		}
		List<Integer> res = new ArrayList<Integer>();
		//n==1
		res.add(0);
		res.add(1);
		for(int i=2;i<=n;i++) {
			int size = res.size();
			for(int j=res.size()-1;j>=0;j--) {
				res.add((1<<(i-1)) + res.get(j));
			}
		}
		return res;
	}
	
	public int test11(int[] arr,int k) {
		if(arr==null || arr.length==0|| k<0) {
			return 0;
		}
		Arrays.sort(arr);
		int i = 0;
		int j = 0;
		int res = 0;
		while(j<arr.length) {
			if(arr[j]-arr[i]==k) {
				res ++;
				i++;
				j++;
				while(i<arr.length && arr[i]==arr[i-1]) i++;
				while(j<arr.length && arr[j]==arr[j-1]) j++;
			} else if(arr[j]-arr[i]>k) {
				i++;
			} else {
				j++;
			}
		}
		return res;
	}
	
	public int test12(int[] arr) {
		if(arr==null || arr.length==0) {
			return -1;
		}
		Map<Integer,Integer> map = new HashMap<>();
		int res = 0;
		int len = 0;
		for(int i : arr) {
			if(!map.containsKey(i)) {
				int left = map.containsKey(i-1)? map.get(i-1):0;
				int right = map.containsKey(i+1)? map.get(i+1):0;
				len = left + right + 1;
				map.put(i, len);
				res = Math.max(res, len);
				map.put(i-left, len);
				map.put(i+right, len);
			} else {
				continue;
			}
		}
		return res;
	}
	
	public int test13(int[] arr) {
		if(arr==null || arr.length==0) {
			return -1;
		}
		int res = arr[0];
		int count = 1;
		for(int i=1;i<arr.length;i++) {
			if(res==arr[i]) {
				count ++;
			} else {
				count --;
			}
			if(count==0) {
				res = arr[i];
				count = 1;
			}
		}
		return res;
	}
	
	public int test14(int[] arr) {
		if(arr==null || arr.length==0) {
			return -1;
		}
		int res = 0;
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==1) {
				count ++;
				res = Math.max(res, count);
			} else {
				count = 0;
			}
		}
		return res;
	}
	
	public static int test15(int[] arr) {
		if(arr==null || arr.length==0) {
			return -1;
		}
		int sum = 0;
		int tmp = 0;
		for(int i=0;i<arr.length;i++) {
			tmp += arr[i];
			sum = Math.max(sum, tmp);
			if(tmp<0) {
				tmp = 0;
			}
		}
		return sum;
	}
	
	public int test16(int[] arr1,int[] arr2) {
		if(arr1==null && arr2==null) {
			return -1;
		} else if(arr1==null) {
			return arr2[arr2.length/2];
		} else if(arr2==null){
			return arr1[arr1.length/2];
		}
		int h = 0;
		int i = 0;
		int j = 0;
		int m = 0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]<=arr2[j]) {
				i++;
				m++;
				if(h==m) {
					return arr1[i];
				}
			} else if(arr1[i]>arr2[j]) {
				j++;
				m++;
				if(h == m) {
					return arr2[j];
				}
			}
		}
		return -1;
	}
	public double test166(int[] a,int[] b) {
		int len1 = a.length;
		int len2 = b.length;
		int total = len1 + len2;
		if(total % 2 != 0) {
			return (double)findKth(a,0,len1-1,b,0,len2-1,total/2+1);
		} else {
			double k1 = findKth(a,0,len1-1,b,0,len2-1,total/2);
			double k2 = findKth(a,0,len1-1,b,0,len2-1,total/2+1);
			return (double)(k1+k2)/2;
		}
	}
	public int findKth(int[] a,int astart,int aend,int[] b,int bstart,int bend,int k) {
		int lena = aend - astart+1;
		int lenb = bend - bstart+1;
		if(lenb>lena) {
			return findKth(b,bstart,bend,a,astart,aend,k);
		}
		int blen = Math.min(k/2, lenb);
		int alen = k - blen;
		if(a[astart+alen-1]<b[bstart+blen-1]) {
			return findKth(a,astart+alen,aend,b,bstart,bend,k-alen);
		} else if(a[astart+alen-1]>b[bstart+blen-1]) {
			return findKth(a,astart,aend,b,bstart+blen,bend,k-blen);
		} else {
			return a[astart+alen-1];
		}
	}
	
	public int test17(int[] arr) {
		if(arr==null || arr.length==0) {
			return -1;
		}
		int res = arr.length;
		for(int i=0;i<arr.length;i++) {
			res ^= arr[i];
			res ^= i;
		}
		return res;
	}
	
	public int[] test18(int[] arr) {
		if(arr == null || arr.length==0 ){
			return null;
		}
		int index = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				arr[index] = arr[i];
				index++;
			}
		}
		for(int i=index;i<arr.length;i++) {
			arr[i] = 0;
		}
		return arr;
	}
	
	public void test19(int[] nums) {
		if(nums==null || nums.length==0) {
			return;
		}
		int index = -1;
		for(int i=nums.length-2;i>=0;i--) {
			if(nums[i]<nums[i+1]) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			reverse(nums,0,nums.length-1);
		}
		int biggerIndex = index+1;
		for(int i=nums.length-1;i>=0;i--) {
			if(nums[i]>nums[index]) {
				biggerIndex = i;
				break;
			}
		}
		int tmp = nums[index];
		nums[index] = nums[biggerIndex];
		nums[biggerIndex] = tmp;
		
		reverse(nums,index+1,nums.length-1);
	}
	public void reverse(int[] nums,int start,int end) {
		while(start<end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
	
	public List<List<Integer>> test20(int rows) {
		if(rows<0) {
			return null;
		}
		List<List<Integer>> res =  new ArrayList<>();
		List<Integer> row = new ArrayList<>();
		for(int i=0;i<rows;i++) {
			row.add(0, 1);
			for(int j=1;j<i;j++) {
				row.set(j, row.get(j)+row.get(j+1));
			}
			res.add(new ArrayList<>(row));
		}
		return res;
	}
	public void test2020(int rows) {
		int[] arr = new int[rows];
		arr[0] = 1;
		for(int i=1;i<rows;i++) {
			for(int j=i;j>0;j--) {
				arr[j] += arr[j-1];
			}
		}
	}
	
	public String test21(int n,int k) {
		List<Integer> list = new ArrayList<Integer>();
		int[] fac = new int[n+1];
		int sum = 1;
		fac[0] = 1;
		for(int i=1;i<=n;i++) {
			sum *= fac[i-1];
			fac[i] = sum;
		}
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		k--;
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			int index = k%fac[n-i];
			sb.append(String.valueOf(list.get(index)));
			list.remove(index);
			k = k - index*fac[n-i];
		}
		return sb.toString();
	}
	
	public int[] test22(int[] nums) {
		if(nums==null || nums.length==0) {
			return null;
		}
		int tmp = 0;
		for(int i=nums.length-1;i>=0;i--) {
			if(nums[i]<9) {
				nums[i]++;
				return nums;
			} else {
				nums[i] = 0;
			}
		}
		int[] news = new int[nums.length+1];
		news[0] = 1;
		return news;
	}
	
	public int test23(int[] nums) {
		if(nums==null || nums.length==0) {
			return -1;
		}
		int len = 0;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]!=nums[i-1]) {
				nums[len] = nums[i];
				len++;
			}
		}
		return len;
	}
	
	public int test24(int[] nums) {
		if(nums==null || nums.length==0) {
			return -1;
		}
		int count = 0;
		int len = 1;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]!=nums[i-1]) {
				nums[len++] = nums[i];
				count = 0;
			} else {
				count ++;
				if(count<2) {
					nums[len++] = nums[i];
				}
			}
		}
		return len;
	}
	
	public int test25(int[] nums,int k) {
		if(nums==null || nums.length==0) {
			return -1;
		}
		int len = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=k) {
				nums[len++] = k;
			}
		}
		return len;
	}
	
	public int[] test26(int[] nums,int k) {
		if(nums==null || nums.length==0) {
			return null;
		}
		reverse1(nums,0,nums.length-k-1);
		reverse1(nums,nums.length-k,nums.length-1);
		reverse1(nums,0,nums.length-1);
		return nums;
	}
	public void reverse1(int[] nums,int start,int end) {
		while(start<end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
	
	public int test27(int[] arr,int k) {
		if(arr==null || arr.length==0) {
			return -1;
		}
		int start = 0;
		int end = arr.length-1;
		while(start<end) {
			int mid = start + (end-start)/2;
			if(arr[mid]==k) {
				return mid;
			}
			if(arr[start]>arr[mid]) {
				if(k>arr[mid] && k<=arr[end]) {
					start = mid+1;
				} else {
					end = mid-1;
				}
			} else {
				if(k>=arr[start] && k<arr[mid]) {
					end = mid-1;
				} else {
					start = mid +1;
				}
			}
		}
		return -1;
	}
	
	public int test28(int[] arr,int k) {
		if(arr==null || arr.length==0) {
			return -1;
		}
		int start = 0;
		int end = arr.length-1;
		while(start<end) {
			int mid = start + (end-start)/2;
			if(arr[start]<arr[mid]) {
				if(k>=arr[start] && k<arr[mid]) {
					end = mid-1;
				} else {
					start = mid+1;
				}
			} else if(arr[start]>arr[mid]) {
				if(k>arr[mid] && k<=arr[end]) {
					start = mid+1;
				} else {
					end = mid-1;
				}
			} else {
				start ++;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {

			
	}
}
