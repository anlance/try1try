package club.anlan.leetcode.lower1000.lower100.start81;

public class P98 {
    public static void main(String[] args) {
        P98 p = new P98();
    }

    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) { // 先序遍历
        if(prev!=null)
            System.out.println(prev.val);
        if (root == null)
            return true;

        if (isValidBST(root.left) && (prev == null || root.val > prev.val)) {
            prev = root;
            return isValidBST(root.right);
        }

        return false;
    }


}
