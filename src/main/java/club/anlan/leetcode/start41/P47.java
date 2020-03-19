package club.anlan.leetcode.start41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P47 {
    public static void main(String[] args) {
        P47 p = new P47();
        int[] nums = {1, 1, 2};
        List res = p.permuteUnique(nums);
        res.stream().forEach(i -> System.out.println(i));
    }

    // nums 中 会出现重复的字符
    // 所以只要在上面的步骤中 去重即可
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 0)
            return res;
        Arrays.sort(nums);
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
                while (i + 1 < nums.length && nums[i] == nums[i + 1])
                    ++i;
            }
        }
    }
}
