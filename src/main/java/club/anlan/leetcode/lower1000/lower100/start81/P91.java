package club.anlan.leetcode.lower1000.lower100.start81;

public class P91 {
    public static void main(String[] args) {
        P91 p = new P91();
        String temp = "110";
        System.out.println(p.numDecodings(temp));
    }

    // 10 20  可以表示,还是要用递归。。
    public int numDecodings(String s) {
        if (s.length() <= 0 || s.charAt(0) == '0')
            return 0;
        if (s.length() <= 1)
            return 1;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (s.charAt(1) == '0') {
            if (s.charAt(0) != '1' && s.charAt(0) != '2')
                return 0;
            else
                dp[1] = 1;
        } else {
            int temp = Integer.parseInt(s.charAt(0) + "" + s.charAt(1));
            if (11 <= temp && temp <= 26) {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        }
        for (int i = 2; i < s.length(); ++i) {
            if (s.charAt(i) == '0' && (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2'))
                return 0;
            int x = s.charAt(i) - '0';
            if (1 <= x && x <= 9)
                dp[i] = dp[i - 1];
            int temp = Integer.parseInt(s.charAt(i - 1) + "" + s.charAt(i));
            if (10 <= temp && temp <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }


}
