package club.anlan.leetcode.lower1000.lower100.start21;

public class P25 {
    public static void main(String[] args) {
        P25 p = new P25();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = p.reverseKGroup(node1, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    // 每次反转 前 K 个节点
    // 1    2   3   4   5   6
    // 2    1   4   3   5   6
    // end1  s1   end2  s2
    //   s1       end1   s2  end2
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode reverseNode = null;
        int length = 0;
        // 获得链表的长度
        while (cur != null) {
            cur = cur.next;
            ++length;
        }
        cur = head;
        int index = length / k; // 需要转换的次数
        int changed = k;
        ListNode end1 = null;
        ListNode end2 = null;
        ListNode start1 = null;
        ListNode start2 = null;
        ListNode res = null;
        while (index > 0) {
            while (changed > 0) {
                if (changed == k) {
                    if (index == length / k) {
                        end1 = cur; // 初始化第一个 end1
                    } else {
                        end2 = cur;
                    }
                }
                if(changed == 1){
                    if(index == length/k){
                        start1 = cur; // 初始化第一个 s1
                        res = start1;
                    } else {
                        start2 = cur;
                    }
                }
                ListNode temp = cur;
                cur = cur.next; // 不停后移链表
                // 反转
                temp.next = reverseNode;
                reverseNode = temp;
                --changed;
            }
            changed = k;
            --index;

            // 连接反转的链表
            if (end2 != null) {
                end1.next = start2;
                end1 = end2;
            }
        }
        end1.next = cur;
        return res;
    }
}
