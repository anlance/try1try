package club.anlan.leetcode.lower1000.lower100.start41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P51 {
    public static void main(String[] args) {
        P51 p = new P51();
        List<List<String>> list = p.solveNQueens(8);
        for (List temp : list) {
            temp.forEach(i -> System.out.println(i));
            System.out.println("");
        }
    }

    // n 皇后
    // 行和列不能出现 2 个皇后
    // 对角线也不能出现 2 个皇后
    public List<List<String>> solveNQueens(int n) {
        char[][] map = new char[n][n];
        boolean[] col = new boolean[n];
        boolean[] diaLeft = new boolean[2 * n - 1]; // -n+1 -n+2 .... -1 0 1 ... n-2 n-1  (每个加上 n-1) => 0 1 2 3 ... 2n-2
        boolean[] diaRight = new boolean[2 * n - 1];// 0 1 ... 2n-3 2n-2
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], '.');
        }
        Arrays.fill(col, false);
        Arrays.fill(diaLeft, false);
        Arrays.fill(diaRight, false);
        List<List<String>> res = new ArrayList<>();
        dfs(res, 0, n, map, col, diaLeft, diaRight);
        return res;
    }

    public void dfs(List<List<String>> res, int i, int n, char[][] map, boolean[] col, boolean[] diaLeft, boolean[] diaRight) {
        if (n == 0) {
            List<String> tempList = new ArrayList<>();
            for (int k = 0; k < col.length; ++k) {
                String temp = "";
                for (int j = 0; j < col.length; ++j) {
                    temp += map[k][j];
                }
                tempList.add(temp);
            }
            res.add(tempList);
        } else {
            for (int j = 0; j < col.length; ++j) { // 每一行 必定 放置一个皇后 (i 是当前行)
                int left = i - j + col.length - 1;
                int right = j + i;
                if (col[j] || diaLeft[left] || diaRight[right])
                    continue;
                else {
                    col[j] = true;
                    diaLeft[left] = true;
                    diaRight[right] = true;
                    map[i][j] = 'Q';
                    dfs(res, i + 1, n - 1, map, col, diaLeft, diaRight);
                    col[j] = false;
                    diaLeft[left] = false;
                    diaRight[right] = false;
                    map[i][j] = '.';
                }
            }
        }
    }
}
