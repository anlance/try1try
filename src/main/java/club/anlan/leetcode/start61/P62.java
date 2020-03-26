package club.anlan.leetcode.start61;

public class P62 {
    public static void main(String[] args) {
        P62 p = new P62();
        System.out.println(p.uniquePaths(10, 10));
    }

    public int uniquePaths(int m, int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return m;
        int [][] dp = new int[m][n];
        for(int i=0;i<m;++i){
            dp[i][0]=1;
        }
        for(int i=0;i<n;++i){
            dp[0][i]=1;
        }
        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
