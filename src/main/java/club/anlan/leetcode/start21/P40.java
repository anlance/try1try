package club.anlan.leetcode.start21;

import java.util.*;

public class P40 {
    public static void main(String[] args) {
        P40 p = new P40();
        int[] nums = {2,5,2,1,2};
        List list = p.combinationSum2(nums, 5);
        list.stream().forEach(i -> System.out.println(i));
    }

    // 只能取数组中的元素，有点多数之和的味道了，直接 map 搞起（好像回溯还是操作简单点）
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        Set<String> set = new HashSet<>();
        dfs(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    // 每次只能从当前位置之后取出元素
    public void dfs(int[] candi, int index, int target, List<List<Integer>> res, List<Integer> list) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(list);
            // 有个去重的操作
            res.add(temp);
        } else if (target > 0) { // 仍然会存在一些多余的操作
            for (int i = index; i < candi.length; ++i) {
                list.add(candi[i]);
                dfs(candi, i + 1, target - candi[i], res, list);
                list.remove(list.size() - 1);
                // 去重
                while (i + 1 < candi.length && candi[i] == candi[i + 1])
                    ++i;
            }
        }
    }
}
