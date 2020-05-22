package club.anlan.leetcode.lower1000.lower100.start61;

public class P70 {
    public static void main(String[] args) {
        P70 p = new P70();
        System.out.println(p.climbStairs(3));
    }

    // 🐸跳台阶
    public int climbStairs(int n) {
        if (n <= 1)
            return 1;
        if (n == 2)
            return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
