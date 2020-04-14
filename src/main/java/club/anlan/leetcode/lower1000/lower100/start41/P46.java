package club.anlan.leetcode.lower1000.lower100.start41;

import java.util.ArrayList;
import java.util.List;

public class P46 {
    public static void main(String[] args) {
        P46 p = new P46();
        int[] nums = {1};
        List res = p.permute(nums);
        res.stream().forEach(i-> System.out.println(i));
    }

    // 全排列
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length<=0)
            return res;
        boolean[] visited = new boolean[nums.length];
        dfs(nums, res, temp, visited);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {
                temp.add(nums[i]);
                visited[i] = true;
                dfs(nums, res, temp, visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
