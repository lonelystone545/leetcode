package com.wy.array;

/*
 * 134. Gas Station 
 *  There are N gas stations along a circular route, where the amount of gas at station i is gas[i]. 
	You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations. 
	Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
	
	思路：
		 方法一：每个站点都作为起始点，开始遍历，判断油差是否小于0，如果小于，则以下一个站点为起始点继续执行上述过程，如果不小于，则带着
		  之前的剩油量继续向前走，直至小于0或者遍历结束。这样解法时间复杂度是O(n^2)，在leetcode中会超时。
		  
		 方法二：只需要一次遍历，时间复杂度O(n).
		 		从第0个站点开始，假设到p站点时，油差<0   sum1 = diff[0] +diff[1] + … + diff[p]<0
		 		下面只需要选择p+1站点作为起始点即可，不需要从第1个站点尝试，因为这样可能还没到p，sum就小于0了，少加了站点0的油。
		 		在遍历到最后的时候，还有必要绕圈回来，再次验证么？这是不需要的。只需要记录一个变量用来存储所有的油差，如果小于0，
		 		则不存在这样站点，如果不小于0，则肯定满足。
		 		
		 		
	假设从站点 i 出发，到达站点 k 之前，依然能保证油箱里油没见底儿，从k 出发后，见底儿了。那么就说明 diff[i] + diff[i+1] + … + diff[k] < 0，而除掉diff[k]以外，从diff[i]开始的累加都是 >= 0的。也就是说diff[i] 也是 >= 0的，这个时候我们还有必要从站点 i + 1尝试吗？仔细一想就知道：车要是从站点 i+1出发，到达站点k后，甚至还没到站点k，油箱就见底儿了，因为少加了站点 i 的油。。。 
　　因此，当我们发现到达k 站点邮箱见底儿后，i 到 k 这些站点都不用作为出发点来试验了，肯定不满足条件，只需要从k+1站点尝试即可！因此解法时间复杂度从O(n2)降到了 O(2n)。之所以是O(2n)，是因为将k+1站作为始发站，车得绕圈开回k，来验证k+1是否满足。 
　　等等，真的需要这样吗？ 
　　我们模拟一下过程： 
　　a. 最开始，站点0是始发站，假设车开出站点p后，油箱空了，假设sum1 = diff[0] +diff[1] + … + diff[p]，可知sum1 < 0； 
　　b. 根据上面的论述，我们将p+1作为始发站，开出q站后，油箱又空了， 设sum2 = diff[p+1] +diff[p+2] + … + diff[q]，可知sum2 < 0。 
　　c. 将q+1作为始发站，假设一直开到了未循环的最末站，油箱没见底儿，设sum3 = diff[q+1] +diff[q+2] + … + diff[size-1]，可知sum3 >= 0。 
　　要想知道车能否开回 q 站，其实就是在sum3 的基础上，依次加上 diff[0] 到 diff[q]，看看sum3在这个过程中是否会小于0。但是我们之前已经知道 diff[0] 到 diff[p-1] 这段路，油箱能一直保持非负，因此我们只要算算sum3 + sum1是否 <0，就知道能不能开到 p+1站了。 
　　如果能从p+1站开出，只要算算sum3 + sum1 + sum2 是否 < 0，就知都能不能开回q站了。 
　　因为 sum1, sum2 都 < 0，因此如果 sum3 + sum1 + sum2 >=0 那么sum3 + sum1 必然 >= 0，也就是说，只要sum3 + sum1 + sum2 >=0，车必然能开回q站。而sum3 + sum1 + sum2 其实就是 diff数组的总和 Total，遍历完所有元素已经算出来了。 
　　因此 Total 能否 >= 0，就是是否存在这样的站点的 充分必要条件。 
　　这样时间复杂度进一步从O(2n)降到了 O(n)。
 */
public class GasStation {
	
	//时间复杂度O(n)
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas==null || cost==null || gas.length==0 || cost.length==0) return -1;
		
		//记录总共的差值
		int total = 0;
		//从i个站点出发 差值
		int sum = 0;
		//记录上一个站点的位置
		int index = -1;
		for(int i=0;i<gas.length;i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			
			if(sum<0) {
				index = i;
				sum = 0;
			}
		}
		if(total<0) {
			return -1;
		} else {
			return index+1;
		}
	}
	
	
	public int canCompleteCircuit3(int[] gas, int[] cost) {  
        //依次从每一个加油站出发  
        for (int i = 0; i < gas.length; i++) {  
            int j = i;  
            int curgas = gas[j];  
              
            while (curgas >= cost[j]) { //如果当前的汽油量能够到达下一站  
                curgas -= cost[j];      //减去本次的消耗  
                  
                j = (j + 1) % gas.length; //到达下一站  
                if (j == i) return i;   //如果回到了起始站，那么旅行成功  
                  
                curgas += gas[j];       //到下一站后重新加油，继续前进  
            }  
        }  
        return -1;  
    }  
	
	//时间复杂度O(n^2) 会超时
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		
		if(gas.length==1 || cost.length==1) return 0;
		
        int[] dif = new int[gas.length];
        for(int i=0;i<gas.length;i++) {
        	dif[i] = gas[i]-cost[i];
        }
        int sum=0;
        for(int i=0;i<dif.length;i++) {
        	sum += dif[i];
        }
        if(sum<0) return -1;
        sum = 0;
        boolean flag = true;
        for(int i=0;i<dif.length;i++) {
        	for(int j=i;j<dif.length;j++) {
        		sum += dif[j];
        		if(sum<0) {
        			flag=false;
        			break;
        		}
        	}
        	if(flag) {
        		for(int j=0;j<i;j++) {
        			sum+=dif[j];
        			if(sum<0) {
        				flag=false;
        				break;
        			}
        		}
        		if(flag) {
        			return i;
        		}
        	}
        	sum=0;
        	flag = true;
        }
    	return -1;
	}

}
