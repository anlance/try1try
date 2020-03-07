package club.anlan.leetcode.start21;

public class P24 {
    public static void main(String[] args) {
        P24 p = new P24();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node = new ListNode(6);
        node3.next=node4;
        ListNode res = p.swapPairs(node1);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    // 交换临近的两个节点  1 2 3 4
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head; // 0 1 2 3 4
        ListNode curNode = res;
        while (curNode.next != null && curNode.next.next!=null){
            ListNode temp = curNode.next; // 1
            curNode.next=curNode.next.next; // 0 2 3 4
            temp.next = curNode.next.next; // 1 3 4   0 2 3 4
            curNode.next.next=temp; // 0 2 1 3 4
            curNode=curNode.next.next;
        }
        return res.next;
    }   
}
