package club.anlan.leetcode.lower1000.lower200.start101;

public class P114 {
    public void flatten(TreeNode root) {
        if (root == null || (root.right == null && root.left == null))
            return;
        if (root.right == null)
            root.right = root.left;
        else if(root.left!=null){
            TreeNode r = root.left;
            while (r.right != null)
                r = r.right;
            r.right = root.right;
            root.right = root.left;
        }
        root.left = null;
        flatten(root.right);
        return;
    }
}
