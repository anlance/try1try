package club.anlan.leetcode.lower1000.lower200.start101;

import java.util.ArrayList;
import java.util.List;

public class P116 {
    public Node connect(Node root) {
        List<List<Node>> res = new ArrayList<>();
        init(res, root, 0);
        for (List<Node> list : res) {
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
        }
        return root;
    }

    public void init(List<List<Node>> res, Node root, int level) {
        if (root == null)
            return;
        List<Node> list = null;
        if (level == res.size()) {
            list = new ArrayList<>();
            res.add(list);
        } else {
            list = res.get(level);
        }
        list.add(root);
        init(res, root.left, level + 1);
        init(res, root.right, level + 1);
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node next;
}