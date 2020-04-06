package club.anlan.leetcode.start81;

public class P83 {
    public static void main(String[] args) {
        P83 p = new P83();
    }

    // 去重
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode slow = cur;
        while (cur != null) {
            if (cur.val != slow.val) {
                slow.next = cur;
                slow = slow.next;
            }
            cur = cur.next;
        }
        if (slow != cur) {
            slow.next = cur;
        }
        return head;
    }
}
