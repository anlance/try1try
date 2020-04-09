import java.util.*;

public class Solution {
    // 例如：
    // 原数组： 1 2 3 -3
    // 前缀和   1 3 6  3
    // 当前缀和相等的时候，表面 (i,j] 子数组的和为 0
    // 此时 数组应当在 j-1 位置断开。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Long, Integer> map = new HashMap<>();
        long curr = 0;
        int max = -1;
        long tot = 0;
        map.put(0L, 0);
        for (int i = 0; i < n; ++i) {
            curr += sc.nextInt();
            max = Math.max(max, map.getOrDefault(curr, -1)); // max -> 子数组开始的位置
            tot += i-max;
            map.put(curr, i+1);
        }
        System.out.println(tot);
    }


}
