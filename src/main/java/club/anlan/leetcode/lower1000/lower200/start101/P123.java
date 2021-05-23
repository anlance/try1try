package club.anlan.leetcode.lower1000.lower200.start101;

import java.util.Arrays;

/**
 * 类
 *
 * @author lan
 * @version 1.0
 * @date 2021/5/23 15:06
 */
public class P123 {

    /**
     * 原始 dp
     * dp[k,i] = max(dp[k-1,i], prices[i]-prices[j]+dp[k,j-1])
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int maxProfit1 = 0;
        int maxProfit2 = 0;
        int getPrice1 = 0;
        int getPrice2 = 0;
        for (int price : prices) {
            getPrice1 = Math.min(getPrice1, price);
            maxProfit1 = Math.max(maxProfit1, price - getPrice1);
            getPrice2 = Math.min(getPrice2, price - getPrice1);
            maxProfit2 = Math.max(maxProfit2, price - getPrice2);
        }
        return maxProfit2;
    }

    public int maxProfit1(int[] prices) {
        int[][] dp = new int[3][prices.length];
        for (int k=1;k<=2;k++){
            for (int i=0;i<prices.length;i++) {
                int min = prices[0];
                for (int j=1;j<=i;j++){
                    // 0->i 过程中，已经交换 k-1 次后，买入的最小值
                    min = Math.min(min, prices[j] - dp[k-1][j-1]);
                }
                dp[k][i] = Math.max(dp[k-1][i], prices[i] - min);
            }
        }
        return dp[2][prices.length -1];
    }

    public int maxProfit2(int[] prices) {
        int[][] dp = new int[3][prices.length];
        for (int k=1;k<=2;k++){
            int min = prices[0];
            for (int i=0;i<prices.length;i++) {
                min = Math.min(min, prices[i] - dp[k-1][i-1]);
                dp[k][i] = Math.max(dp[k-1][i], prices[i] - min);
            }
        }
        return dp[2][prices.length -1];
    }

    public int maxProfit3(int[] prices) {
        int[][] dp = new int[3][prices.length];
        int[] min = new int[3];
        Arrays.fill(min, prices[0]);
        for (int i=1;i<prices.length;i++){
            for (int k=1;k<=2;k++){
                min[k] = Math.min(min[k], prices[i]  - dp[k-1][i-1]);
                dp[k][i] = Math.max(dp[k-1][i], prices[i] - min[k]);
            }
        }
        return dp[2][prices.length -1];
    }

    public int maxProfit4(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[3];
        int[] min = new int[3];
        Arrays.fill(min, prices[0]);
        for (int i=1;i<prices.length;i++){
            for (int k=1;k<=2;k++){
                min[k] = Math.min(min[k], prices[i]  - dp[k-1]);
                dp[k] = Math.max(dp[k], prices[i] - min[k]);
            }
        }
        return dp[2];
    }

}
