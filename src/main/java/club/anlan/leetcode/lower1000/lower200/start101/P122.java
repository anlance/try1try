package club.anlan.leetcode.lower1000.lower200.start101;

import java.util.Arrays;
import java.util.List;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 * @author lan
 * @version 1.0
 * @date 2021/5/23 14:40
 */
public class P122 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices.length == 1){
            return 0;
        } else {
            for (int i=0;i<prices.length-1;i++){
               if (prices[i+1]>=prices[i]){
                   maxProfit += prices[i+1] - prices[i];
               }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] s = {7,1,5,3,6,4};
        System.out.println(new P122().maxProfit(s));
    }
}
