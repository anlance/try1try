package club.anlan.leetcode.lower1000.lower100.start41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P56 {
    public static void main(String[] args) {
        P56 p = new P56();
        int[][] intervals = {{1, 4}, {0, 2}, {3, 5}};
        int[][] res = p.merge(intervals);
        for (int i = 0; i < res.length; ++i) {
            System.out.println(res[i][0] + ":" + res[i][1]);
        }
    }

    // 将具有交集的区间融合 【1，3】【2，6】->【1，6】
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>(Arrays.asList(intervals));
        res.sort((a, b) -> (a[0] - b[0]));
        for (int i = 1; i < res.size(); ++i) {
            int[] pre = res.get(i - 1);
            int[] cur = res.get(i);
            if (cur[0] <= pre[1]) { // 融合
                pre[1] = Math.max(pre[1], cur[1]);
                res.remove(cur);
                --i;
            }
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); ++i) {
            int[] cur = res.get(i);
            ans[i] = cur;
        }
        return ans;
    }
}
