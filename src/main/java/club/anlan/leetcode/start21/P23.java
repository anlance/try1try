package club.anlan.leetcode.start21;

public class P23 {
    public static void main(String[] args) {
        P23 p = new P23();
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(11);
        node1.next=node2;
        node2.next=node3;
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next=node5;
        node5.next=node6;
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(10);
        node7.next=node8;
        ListNode[] lists = {node1,null,node4,null,node7,null};
        ListNode res =p.mergeKLists(lists);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    // 合并 K 个 有序数组
    // 每次从 k 个里面找到一个最小的，然后该链表进行向后位移，直到所有链表不能位移退出循环
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        boolean[] isFirst = new boolean[k];
        ListNode resNode = new ListNode(0);
        ListNode curNode = resNode;
        while (k > 0) {
            ListNode tempNode = new ListNode(Integer.MAX_VALUE);
            int tempIndex = 0;
            boolean isMoved = false;
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] == null) {
                    if(!isFirst[i]){
                        --k;
                        isFirst[i]=true;
                    }
                    continue;
                }
                if (tempNode.val > lists[i].val) {
                    tempNode = lists[i];
                    tempIndex = i;
                    isMoved = true;
                }
            }
            if (isMoved) {
                lists[tempIndex] = lists[tempIndex].next;
                curNode.next = tempNode;
                curNode = curNode.next;
            }
        }
        return resNode.next;
    }
}

