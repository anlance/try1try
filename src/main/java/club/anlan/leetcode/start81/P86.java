package club.anlan.leetcode.start81;

public class P86 {
    public static void main(String[] args) {
        P86 p = new P86();
    }

    public ListNode partition(ListNode head, int x) {
        ListNode nHead = new ListNode(0);
        ListNode temp = nHead;  // connect ListNode(which's val < x)

        ListNode midHead = new ListNode(0);
        ListNode mid = midHead; // connect ListNode(which's val >= x)
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                temp.next = cur;
                temp = temp.next;
            } else {
                mid.next = cur;
                mid = mid.next;
            }
            cur = cur.next;
        }
        mid.next=null;
        temp.next = midHead.next;
        return nHead.next;
    }
}
