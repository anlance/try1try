package club.anlan.leetcode.lower1000.lower100.start1;

public class P10_right {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        P10_right p10 = new P10_right();
        System.out.println(p10.isMatch(s,p));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < m + 1; ++i)
            dp[i][0] = false;
        for (int j = 1; j < n + 1; ++j)
            dp[0][j] = j > 1 && '*' == p.charAt(j-1) && dp[0][j - 2]; // * 0匹配
        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if ('*' == p.charAt(j - 1))
                    dp[i][j] = dp[i][j - 2]
                            || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                            && dp[i - 1][j];
                else
                    dp[i][j] = (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1))
                            && dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }


}
