package club.anlan.leetcode.start61;

public class P61 {
    public static void main(String[] args) {
        P61 p = new P61();
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode res = p.rotateRight(null,4);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }

    // 反转链表的后 k 个节点
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return head;
        int len = 1;
        ListNode cur = head;
        ListNode first = head;
        ListNode second = head;
        int number = k;
        while (number > 0 && first.next != null) {
            first = first.next;
            ++len;
            --number;
        }
        if (number != -1) { // k 大于链表长度。
            first = head;
            number = k%len;
            while (number > 0 && first.next != null) {
                first = first.next;
                ++len;
                --number;
            }
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = head;
        ListNode newHead = second.next;
        second.next = null;
        return newHead;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
