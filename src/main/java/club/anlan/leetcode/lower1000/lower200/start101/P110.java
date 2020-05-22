package club.anlan.leetcode.lower1000.lower200.start101;

public class P110 {
    public boolean isBalanced(TreeNode root) {
        return isOK(root) != -1;
    }

    private int isOK(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int hl = isOK(root.left);
        int hr = isOK(root.right);
        int min = Math.min(hl, hr);
        int max = Math.max(hl, hr);

        if (hl == -1 || hr == -1 || max - min > 1) {
            return -1;
        }
        return 1 + max;
    }
}
