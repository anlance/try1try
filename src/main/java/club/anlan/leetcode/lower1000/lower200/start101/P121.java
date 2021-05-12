package club.anlan.leetcode.lower1000.lower200.start101;

import java.util.Arrays;
import java.util.List;

/**
 * 类
 *
 * @author lan
 * @version 1.0
 * @date 2021/5/12 20:10
 */
public class P121 {

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     */
    public int maxProfit(Integer[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPf = 0;
        for (int i=0; i<prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            if (maxPf < prices[i] - minPrice) {
                maxPf = prices[i] - minPrice;
            }
        }
        return maxPf;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7,1,5,3,6,4);
        Integer[] s = list.toArray(new Integer[list.size()]);
        System.out.println(new P121().maxProfit(s));
    }
}
