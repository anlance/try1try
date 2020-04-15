package club.anlan.leetcode.lower1000.lower200.start101;

import java.util.ArrayList;
import java.util.List;

public class P102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root,res,0);
        return res;
    }

    public void levelOrder(TreeNode root, List<List<Integer>> res,int level) {
        if(root!=null){
            List<Integer> list = null;
            if(level>=res.size()){
                list = new ArrayList<>();
                res.add(list);
            } else {
                list = res.get(level);
            }
            list.add(root.val);
            levelOrder(root.left,res,level+1);
            levelOrder(root.right,res,level+1);
        }
    }
}
