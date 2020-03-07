package club.anlan.nowcoder.start1;

import java.util.ArrayList;
import java.util.List;

public class P3 {
    public static void main(String[] args) {
        P3 p = new P3();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        List list;
        list = p.printListFromTailToHead(null);
        list.forEach(i -> System.out.println(i));
        list = p.printListFromTailToHead(node1);
        list.forEach(i -> System.out.println(i));
    }

    // 从尾到头 返回链表
    // 反转 ListNode 或者反转 List
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null)
            return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        ListNode cur = null;
        ListNode temp = listNode;
        while (listNode != null) {
            temp = listNode;
            listNode = listNode.next;
            temp.next=cur;
            cur = temp;
        }
        while (temp != null) {
            ans.add(temp.val);
            temp = temp.next;
        }
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

