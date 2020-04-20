package club.anlan.leetcode.lower1000.lower200.start101;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class P111 {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(current.left == null && current.right == null){
                    return count;
                }
                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
            }
        }
        return count;
    }
}
