package club.anlan.nowcoder.start21;

import java.util.ArrayList;

public class P22 {

    // 从上往下打印出二叉树
    //从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.remove(0);
            res.add(temp.val);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null)
                queue.add(temp.right);
        }
        return res;
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