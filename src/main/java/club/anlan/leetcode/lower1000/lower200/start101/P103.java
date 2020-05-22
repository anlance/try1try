package club.anlan.leetcode.lower1000.lower200.start101;

import java.util.ArrayList;
import java.util.List;

public class P103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        res.add(list);
        zigzagLevelOrder(root, 0, res);
        return res;
    }

    public void zigzagLevelOrder(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null)
            return;
        List<Integer> list = null;
        if (level == res.size()) {
            list = new ArrayList<>();
            res.add(list);
        } else
            list = res.get(level);
        if(level%2==0)
            list.add(root.val);
        else
            list.add(0,root.val);
        zigzagLevelOrder(root.left, level + 1, res);
        zigzagLevelOrder(root.right, level + 1, res);
    }
}
