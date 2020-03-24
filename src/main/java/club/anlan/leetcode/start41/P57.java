package club.anlan.leetcode.start41;

import java.util.ArrayList;
import java.util.List;

public class P57 {
    public static void main(String[] args) {
        P57 p = new P57();
        int[][] ints = {{1, 5}};
        int[] newInt = {2, 7};
        int[][] res = p.insert(ints, newInt);
        for (int i = 0; i < res.length; ++i) {
            System.out.println(res[i][0] + ":" + res[i][1]);
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length <= 0) {
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }
        if (intervals[0][0] == newInterval[1]){
            intervals[0][0] = newInterval[0];
            return intervals;
        }
        if(intervals[intervals.length - 1][1] == newInterval[0]){
            intervals[intervals.length - 1][1] = newInterval[1];
            return intervals;
        }

        if (intervals[0][0] > newInterval[1]) { // 比起点还小
            int[][] res = new int[intervals.length + 1][2];
            res[0] = newInterval;
            for (int i = 1; i < res.length; ++i) {
                res[i] = intervals[i - 1];
            }
            return res;
        }
        if (intervals[intervals.length - 1][1] < newInterval[0]) { // 比终点还大
            int[][] res = new int[intervals.length + 1][2];
            res[0] = newInterval;
            for (int i = 0; i < res.length - 1; ++i) {
                res[i] = intervals[i];
            }
            res[res.length - 1] = newInterval;
            return res;
        }
        List<int[]> ans = new ArrayList<>();
        boolean isOpen = false;
        boolean isClose = false;
        int x = -1;
        int y = -1;
        for (int i = 0; i < intervals.length; ++i) {
            if (!isOpen && newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) { // 起点在[a,b]之间
                isOpen = true;
                x = intervals[i][0];
            }
            if (!isOpen && newInterval[0] < intervals[i][0]) { // 起点在 [a,b] [c,d]之间
                isOpen = true;
                x = newInterval[0];
            }

            if (!isClose && newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) { //终点在[a,b]之间
                isClose = true;

                y = intervals[i][1];
                newInterval[0] = x;
                newInterval[1] = y;
                ans.add(newInterval);
                continue;
            }
            if (!isClose && newInterval[1] < intervals[i][0]) { // 终点在 [a,b] [c,d]之间
                isClose = true;
                newInterval[0] = x;
                ans.add(newInterval);
            }
            if (isOpen == isClose) {
                ans.add(intervals[i]);
            }
            if(!isClose && i==intervals.length-1){
                newInterval[0]=x;
                ans.add(newInterval);
            }
        }
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); ++i) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
