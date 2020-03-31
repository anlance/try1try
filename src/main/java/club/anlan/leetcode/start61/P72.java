package club.anlan.leetcode.start61;

public class P72 {

    public static void main(String[] args) {
        P72 p = new P72();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(p.minDistance(word1, word2));
    }

    // 将 word1 转换为 word2 （每次可以添加、删除或者替换一个字符），返回最小操作次数
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; ++i) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; ++i) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); ++i) {
            for (int j = 1; j <= word2.length(); ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) { // 如果相同
                    int temp = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1; // 插入 或者 删除 （这两种操作需要 +1 ）
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1]); // 不进行操作
                } else { // 如果不相等
                    int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);// 插入 或者 删除
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1]) + 1; // 替换 （ 3种操作的最小结果 +1 ）
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }


}
