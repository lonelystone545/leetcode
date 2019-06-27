package com.wy.array;


/*
 * 
 * 
 *  135. Candy 
 * 
 *  There are N children standing in a line. Each child is assigned a rating value. 
	You are giving candies to these children subjected to the following requirements: 
	Each child must have at least one candy.
	Children with a higher rating get more candies than their neighbors.
	What is the minimum candies you must give? 
 * 
 * 这题类似于trapping water题目。无论是填水还是发糖，影响因素都不只是一边，都是由左右两边的最大值最小值决定的。
 * 1 如果孩子i+1的rate大于孩子i的rate，那么孩子i+1的糖果=孩子i的糖果+1，但是如果小于或者等于，并不能确定给
 * 	  孩子i+1多少颗糖。这时可以先不处理，然后逆序过来遍历一次，处理这些孩子。最后取出两者的最大值累加即可。
 * 	  空间复杂度O(n)
 * 
 * 2 辅助数组的作用就是进行遍历时记录最大值和最小值。但是如果是非递减序列，就不需要辅助空间了，因为每个孩子给的糖果数就能确定下来
 * 	  但是如果是递减序列，就不能唯一的确定了，如 1 5 4 3 ，第一个孩子给糖果数1，那第二个孩子给的糖果数是多少呢？是根据递减序列的长度决定的。
 * 	 5 4 3递减序列长度是3，那第二个孩子应该给3个糖果，第三个孩子应该给2个糖果，第四个孩子应该给4个糖果。
 *   那可以先对其不进行处理，递减序列的第一个已经给了糖果，先不管，4 3 ，长度为count：2，给的糖果总数为1+2=3，5对应的孩子现在的糖果数是pre:2，
 *   （count>=2）5对应的这个孩子的糖果应该重新分配，在总数上加(count-pre)+1
 * 	 
 */
public class Candy {
	
	//O(1)的空间复杂度
	public int candy2(int[] ratings) {
		if(ratings==null || ratings.length==0) {
			return 0;
		}
		//前一个孩子给的糖果数
		int pre = 1;
		//递减序列的长度（不包含递减序列的第一个数）
		int count = 0;
		//总数sum
		int sum = 1;
		//从第二个孩子开始遍历
		for(int i=1;i<ratings.length;i++) {
			if(ratings[i]>=ratings[i-1]) {
				if(count>0) {
					sum += (1+count)*count/2;
					if(count>=pre) { //对递减序列的第一个数进行重新修正
						sum += count-pre+1;
					}
					//重置
					count = 0;
					pre=1; 
				}
				pre = (ratings[i]==ratings[i-1]? 1:pre+1);
				sum += pre;
			} else {
				count++;
			}
		}
		//如果递减数列一直到结束
		if(count>0) {
			sum += (1+count)*count/2;
			if(count>=pre) {
				sum += count-pre+1;
			}
		}
		return sum;
	}
	
	//两个数组  用一个数组也是ok的，反向遍历时，如果左边的rate比右边高，应该确保左边糖果数多。
	public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) {
        	return 0;
        }
        int[] lefts = new int[ratings.length];
        int[] rights = new int[ratings.length];
        //从左向右遍历
        lefts[0]=1;
        for(int i=1;i<ratings.length;i++) {
        	if(ratings[i]>ratings[i-1]) {
        		lefts[i] = lefts[i-1]+1;
        	} else { 
        		lefts[i] = 1;
        	}
        }
        //从右向左遍历
        rights[ratings.length-1] = 1;
        for(int i=ratings.length-2;i>=0;i--) {
        	if(ratings[i]>ratings[i+1]) {
        		rights[i] = rights[i+1]+1;
        	} else {
        		rights[i] = 1;
        	}
        }
        
        int sum = 0;
        for(int i=0;i<ratings.length;i++) {
        	sum += Math.max(lefts[i], rights[i]);
        }
        return sum;
    }
}
