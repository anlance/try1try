package club.anlan.leetcode.start81;

public class P92 {
    public static void main(String[] args) {
        P92 p = new P92();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode head = p.reverseBetween(listNode1, 1, 3);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode emptyHead = new ListNode(0); // helpful when m==1
        emptyHead.next = head;
        ListNode cur = emptyHead;
        ListNode nHead = head;
        ListNode nTail = head;
        ListNode temp = head;
        ListNode next = null;
        while (cur != null && n >= 0) {
            --m;
            --n;
            if (m == 0) {
                nTail = cur.next;
                nHead = cur; // the start
                temp = nTail;
                cur = cur.next; // skip one step
                --n;
            }
            if (m < 0) {
                next = cur.next; // restore the next Node
                cur.next = temp;
                temp = cur;
                cur = next; // go to the next Node
            } else
                cur = cur.next;
        }
        nHead.next = temp;
        nTail.next = next;
        return emptyHead.next;
    }
}
