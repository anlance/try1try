package club.anlan.leetcode.start81;

import java.util.Arrays;
import java.util.Collections;

public class P85 {
    public static void main(String[] args) {
        P85 p = new P85();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(p.maximalRectangle(matrix));
    }

    // find the largest rectangle
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length <= 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0)
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                else
                    dp[i][j] = matrix[i][j] == '1' ? (dp[i - 1][j] + 1) : 0; // down
                int min = dp[i][j];
                for (int k = j; k >= 0; k--) {
                    if (min == 0)
                        break;
                    if (dp[i][k] < min)
                        min = dp[i][k];
                    maxArea = Math.max(maxArea, min * (j - k + 1));
                }
            }
        }
        return maxArea;
    }
}
