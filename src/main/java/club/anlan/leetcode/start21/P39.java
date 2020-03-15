package club.anlan.leetcode.start21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P39 {
    public static void main(String[] args) {
        P39 p = new P39();
        int[] nums = {1};
        List list = p.combinationSum(nums, 1);
        list.stream().forEach(i -> System.out.println(i));
    }

    // 给一个不重复的整数数组和一个 target ，找到列表中所有数（可重复，必须是数组中的元素）和 满足 target 的情况
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    // 每次只能从当前位置以及之后的取出元素
    public void dfs(int[] candi, int index, int target, List<List<Integer>> res, List<Integer> list) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
        } else if (target > 0) { // 仍然会存在一些多余的操作
            for (int i = index; i < candi.length; ++i) {
                list.add(candi[i]);
                dfs(candi, i, target - candi[i], res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
