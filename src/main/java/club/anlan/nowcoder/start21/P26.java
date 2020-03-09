package club.anlan.nowcoder.start21;

public class P26 {

    // 二叉搜索树与双向链表

    // 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    // 要求不能创建任何新的结点，只能调整树中结点指针的指向。

    // left -> 下一个节点
    //上一个节点 <- right
    // 中序遍历

    TreeNode head = null;
    TreeNode res = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        Convert(pRootOfTree.left);
        if(head==null){
            head=pRootOfTree;
            res=pRootOfTree;
        } else {
            head.right=pRootOfTree;
            pRootOfTree.left=head;
            head = head.right;
        }
        Convert(pRootOfTree.right);
        return res;
    }

}
