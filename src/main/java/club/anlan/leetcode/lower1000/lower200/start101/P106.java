package club.anlan.leetcode.lower1000.lower200.start101;

import java.util.Arrays;

public class P106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index = 0;
        for (int i = 1; i < inorder.length; ++i) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        if (postorder.length > 1) {
            root.left = buildTree(Arrays.copyOfRange(inorder, 0, index),
                    Arrays.copyOfRange(postorder, 0, index));
            root.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length),
                    Arrays.copyOfRange(postorder, index , postorder.length-1));
        }
        return root;
    }
}
