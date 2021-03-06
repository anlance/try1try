package club.anlan.leetcode.lower1000.lower200.start101;

public class P115 {

    public int numDistinct(String s, String t) {
        int sum[][] = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i <= s.length(); i++)
            sum[i][0] = 1;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < t.length(); j++) {
                sum[i + 1][j + 1] = sum[i][j + 1];
                if( s.charAt(i) == t.charAt(j) )
                    sum[i + 1][j + 1] += sum[i][j];
            }
        }
        return sum[s.length()][t.length()];
    }
}
