package club.anlan.nowcoder.start11;

public class P15 {

    // 反转链表
    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode temp = null;
        ListNode tail = null;
        while (cur!=null){
            temp=cur;
            cur = cur.next;
            temp.next=tail;
            tail=temp;
        }
        return tail;
    }
}
