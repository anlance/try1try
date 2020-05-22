package club.anlan.leetcode.lower1000.lower100.start81;

import java.util.ArrayList;
import java.util.List;

public class P95 {
    public static void main(String[] args) {
        P95 p = new P95();
        List<TreeNode> res = p.generateTrees(3);
        for (TreeNode node : res) {
            p.preOder(node);
            System.out.println();
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        return createBST(1,n);
    }
    public List<TreeNode> createBST(int si,int ei){
        if(si>ei){
            List<TreeNode> br=new ArrayList<>();
            br.add(null);
            return br;
        }
        List<TreeNode> ans=new ArrayList<>();
        for(int i=si;i<=ei;i++){
            List<TreeNode> lr=createBST(si,i-1);
            List<TreeNode> rr=createBST(i+1,ei);
            for(int j=0;j<lr.size();j++){
                for(int k=0;k<rr.size();k++){
                    TreeNode curNode=new TreeNode(i);
                    curNode.left=lr.get(j);
                    curNode.right=rr.get(k);
                    ans.add(curNode);
                }
            }
        }
        return ans;

    }

    public void preOder(TreeNode root) {
        if (root == null) {
            System.out.print("null,");
        } else {
            System.out.print(root.val + ",");
            if(root.left==null&&root.right==null)
                return;
            preOder(root.left);
            preOder(root.right);
        }
    }
}
