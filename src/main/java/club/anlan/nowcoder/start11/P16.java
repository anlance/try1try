package club.anlan.nowcoder.start11;

public class P16 {
    // 合并两个排序的链表
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        ListNode temp = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp = list1;
                list1 = list1.next;

            } else {
                temp = list2;
                list2 = list2.next;
            }
            cur.next = temp;
            cur = cur.next;
        }
        if(list1!=null)
            cur.next=list1;
        else if(list2!=null)
            cur.next=list2;
        return res.next;
    }
}
