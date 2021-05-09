package club.anlan.leetcode.lower1000.lower200.start101;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 *
 * @author lan
 * @version 1.0
 * @date 2021/5/9 18:10
 */
public class P120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];

        List<Integer> list = triangle.get(len - 1);
        for (int i = 0; i < len; i++)
            dp[i] = list.get(i);

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]);
                dp[j] += triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new P120().minimumTotal(Arrays.asList(Arrays.asList(2),Arrays.asList(3,4),
                Arrays.asList(6,5,7),Arrays.asList(4,1,8,3)))));
    }
}
