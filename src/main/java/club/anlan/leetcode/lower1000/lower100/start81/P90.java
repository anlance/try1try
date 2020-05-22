package club.anlan.leetcode.lower1000.lower100.start81;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90 {
    public static void main(String[] args) {
        P90 p = new P90();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = p.subsetsWithDup(nums);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; ++i) {
            list.add(nums[i]);
            dfs(res, list, nums, i + 1);
            list.remove(list.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i])
                ++i;
        }
    }

}
