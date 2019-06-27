package com.wy.array;


/*
 *  122. Best Time to Buy and Sell Stock II 
 *  Say you have an array for which the ith element is the price of a given stock on day i.
	Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockII {
	
	public int maxProfit2(int[] prices) {
       int total = 0;
       for(int i=0;i<prices.length-1;i++) {
    	   if(prices[i+1]>prices[i]) {
    		   int profits = prices[i+1]-prices[i];
    		   total = total + profits;
    	   }
       }
       return total;
    }	
	
	//�ֲ���͵�����;ֲ� ��ߵ�����
	public int maxProfit(int[] prices) {
		
		int total = 0;
		int i = 0;
		while(i<prices.length-1) {
			int buy,sell;
			//�Ҿֲ���͵�
			while(i+1<prices.length && prices[i]>prices[i+1]) {
				i++;
			}
			buy = i;
			//��������,����������һ����
			i++;
			while(i<prices.length && prices[i]>=prices[i-1]) {
				i++;
			}
			sell = i-1;
			total += prices[sell]-prices[buy];
		}
		return total;
	}
}
