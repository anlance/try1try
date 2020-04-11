package club.anlan.leetcode.start81;


import java.util.LinkedList;
import java.util.List;

public class P94 {
    public static void main(String[] args) {
        P94 p = new P94();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderTraversal(root, res);
        return res;
    }

    public void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

