package club.anlan.leetcode.lower1000.lower200.start101;

import java.util.Arrays;

public class P105 {
    // Construct Binary Tree from Preorder and Inorder Traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 1; i < inorder.length; ++i) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }
        if (preorder.length > 1) {
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
                    Arrays.copyOfRange(inorder, 0, index));
            root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                    Arrays.copyOfRange(inorder, index + 1, preorder.length));
        }
        return root;
    }


}
