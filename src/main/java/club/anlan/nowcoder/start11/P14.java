package club.anlan.nowcoder.start11;

import club.anlan.nowcoder.start1.P1;

public class P14 {
    public static void main(String[] args) {
        P14 p = new P14();
    }

    // 链表中倒数第k个结点
    // 输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        while (first!=null && k > 0) {
            first = first.next;
            --k;
        }
        if(k>0)
            return null;
        while (first!=null){
            first=first.next;
            second=second.next;
        }
        return second;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}