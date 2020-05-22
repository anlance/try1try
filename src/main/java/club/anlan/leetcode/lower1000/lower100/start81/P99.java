package club.anlan.leetcode.lower1000.lower100.start81;

import java.util.ArrayList;
import java.util.List;

public class P99 {

    public void recoverTree(TreeNode root) {
        inorder2(root, new ArrayList<>());
    }

    public void inorder2(TreeNode root, List<TreeNode> orderList) {
        if (root == null)
            return;
        inorder2(root.left, orderList);
        orderList.add(root);
        int rootIndex = orderList.size() - 1;
        int lastIndex = rootIndex - 1;
        while (lastIndex >= 0 && orderList.get(lastIndex).val > orderList.get(rootIndex).val) {
            TreeNode r = orderList.get(rootIndex);
            TreeNode l = orderList.get(lastIndex);
            int data = r.val;
            r.val = l.val;
            l.val = data;

            rootIndex--;
            lastIndex--;
        }
        inorder2(root.right, orderList);
    }
}
