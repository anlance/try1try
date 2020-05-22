package club.anlan.nowcoder.start21;

import java.util.ArrayList;

public class P24 {

    // 二叉树中和为某一值的路径
    // 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
    // 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    // (注意: 在返回值的list中，数组长度大的数组靠前)
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        FindPath(root, target, list, 0, res);
        return res;
    }

    public void FindPath(TreeNode root, int target, ArrayList<Integer> list, int temp, ArrayList<ArrayList<Integer>> res) {
        temp += root.val;
        if (temp > target) { // 当前路径和已经大于 target，直接返回
            temp -= root.val;
            return;
        }
        list.add(root.val);
        if (target == temp && root.left == null && root.right == null) //找到一条路径
            res.add((ArrayList<Integer>) list.clone()); // 返回 list 的 一个 clone 对象
        if (root.left != null)
            FindPath(root.left, target, list, temp, res);
        if (root.right != null)
            FindPath(root.right, target, list, temp, res);
        // 消除当前步骤对 temp 和 List 的更改
        temp -= root.val;
        list.remove(list.size() - 1);
    }
}
