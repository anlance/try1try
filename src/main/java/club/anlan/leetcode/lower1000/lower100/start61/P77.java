package club.anlan.leetcode.lower1000.lower100.start61;

import java.util.ArrayList;
import java.util.List;

public class P77 {
    public static void main(String[] args) {
        P77 p = new P77();
        List<List<Integer>> res = p.combine(6, 4);
        res.forEach(i -> i.forEach(j -> System.out.print(j + "")));
    }


    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, 1, k, list, res);
        return res;
    }

    public void dfs(int n, int i, int k, List<Integer> list, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <= n - k + 1; ++j) {
            list.add(j);
            dfs(n, j + 1, k - 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
