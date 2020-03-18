package club.anlan.leetcode.start41;

import java.util.Arrays;

public class P45 {
    public static void main(String[] args) {
        P45 p = new P45();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(p.jump(nums));
    }

    // 每个数组表示当前位置可以跳得最大步数，问跳得最小次数
    // 贪心
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE); // 初始化 dp 数组
        dp[0] = 0;
        for (int i = 0; i < nums.length; ++i) {
            int temp = nums[i];
            for (int k = i + 1; k < nums.length && k < temp + 1 + i; ++k) {
                dp[k] = Math.min(dp[k], dp[i] + 1);
                if (nums.length - 1 == k)
                    return dp[dp.length - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
