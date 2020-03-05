package club.anlan.leetcode.start1;

public class P19 {
    public static void main(String[] args) {
        P19 p = new P19();
        ListNode head = new ListNode(1);
        ListNode curNode = head;
        int i = 2;
        while (i < 6) {
            curNode.next = new ListNode(i);
            curNode = curNode.next;
            ++i;
        }
        ListNode temp = p.removeNthFromEnd(head, 3);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    // 删除倒数第 N 个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode zeroNode = new ListNode(0);
        zeroNode.next = head;

        ListNode first = zeroNode;
        ListNode second = zeroNode;
        while (n > 0) {
            --n;
            second = second.next;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return zeroNode.next;
    }
}

// 链表节点
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}