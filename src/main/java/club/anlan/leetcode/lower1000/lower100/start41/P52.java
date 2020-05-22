package club.anlan.leetcode.lower1000.lower100.start41;

public class P52 {
    public static void main(String[] args) {
        P52 p = new P52();
        System.out.println(p.totalNQueens(4));
    }

    // 返回 N 皇后的放置总数
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] diaLeft = new boolean[2 * n - 1]; // -n+1 -n+2 .... -1 0 1 ... n-2 n-1  (每个加上 n-1) => 0 1 2 3 ... 2n-2
        boolean[] diaRight = new boolean[2 * n - 1];// 0 1 ... 2n-3 2n-2
        int[] res = new int[1];
        dfs(res, 0, n, col, diaLeft, diaRight);
        return res[0];
    }

    public void dfs(int[] res, int i, int n, boolean[] col, boolean[] diaLeft, boolean[] diaRight) {
        if (n == 0) {
            res[0]++;
        } else {
            for (int j = 0; j < col.length; ++j) { // 每一行 必定 放置一个皇后 (i 是当前行)
                int left = i - j + col.length - 1;
                int right = j + i;
                if (col[j] || diaLeft[left] || diaRight[right])
                    continue;
                else {
                    col[j] = true;
                    diaLeft[left] = true;
                    diaRight[right] = true; // 表示 i j 位置放置一个皇后
                    dfs(res, i + 1, n - 1, col, diaLeft, diaRight);
                    col[j] = false;
                    diaLeft[left] = false;
                    diaRight[right] = false;
                }
            }
        }
    }
}
