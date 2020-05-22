package club.anlan.leetcode.lower1000.lower200.start101;

import java.util.ArrayList;
import java.util.List;

public class P113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        pathSum(root, res, new ArrayList<>(), sum);
        return res;
    }

    public void pathSum(TreeNode root, List<List<Integer>> res, List<Integer> list, int sum) {
        if (root.left == null && root.right == null && root.val == sum) {
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
        if (root.left != null) {
            list.add(root.val);
            pathSum(root.left, res, list, sum - root.val);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.val);
            pathSum(root.right, res, list, sum - root.val);
            list.remove(list.size() - 1);
        }
    }
}
