package club.anlan.leetcode.lower1000.lower200.start101;

import java.util.ArrayList;
import java.util.List;

public class P109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        return sortedListToBST(0, list.size() - 1, list);
    }

    public TreeNode sortedListToBST(int first, int last, List<Integer> list) {
        if (first > last) return null;
        int middle = first + (last - first) / 2;
        TreeNode root = new TreeNode(list.get(middle));
        root.left = sortedListToBST(first, middle - 1, list);
        root.right = sortedListToBST(middle + 1, last, list);
        return root;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
