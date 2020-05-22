package club.anlan.nowcoder.start11;

public class P18 {

    // 二叉树的镜像

    //          8
    //    	   /  \
    //    	  6   10
    //    	 / \  / \
    //    	5  7 9 11
    //    	镜像二叉树
    //    	    8
    //    	   /  \
    //    	  10   6
    //    	 / \  / \
    //    	11 9 7  5

    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }


}
