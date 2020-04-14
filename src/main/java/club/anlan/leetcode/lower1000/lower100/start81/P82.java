package club.anlan.leetcode.lower1000.lower100.start81;

public class P82 {
    public static void main(String[] args) {
        P82 p = new P82();
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode cur = temp;
        ListNode slow = cur;
        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.val != slow.next.val) {
                if (count >= 2) {
                    slow.next = cur;
                }
                slow = slow.next;
                count = 0;
            }
            ++count;
        }
        return temp.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
