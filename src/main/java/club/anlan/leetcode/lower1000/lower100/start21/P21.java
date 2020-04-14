package club.anlan.leetcode.lower1000.lower100.start21;

public class P21 {
    public static void main(String[] args) {
        P21 p = new P21();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next=node5;
        node5.next=node6;
        ListNode res = p.mergeTwoLists(node1,node4);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    // 合并两个有序列表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1!=null && l2!=null){
            if(l1.val<l2.val){
                ListNode temp = l1;
                l1=l1.next;
                cur.next = temp;
            } else{
                ListNode temp = l2;
                l2=l2.next;
                cur.next = temp;
            }
            cur = cur.next;
        }
        if(l1!=null)
            cur.next=l1;
        if(l2!=null)
            cur.next=l2;
        return res.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}