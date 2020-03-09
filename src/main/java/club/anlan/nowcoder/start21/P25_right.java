package club.anlan.nowcoder.start21;

public class P25_right {
    // 直接将复制的链表生在原链表中
    // 然后拆分即可
    // 1 2 3 4 5
    // |   |
    // ----

    //=》

    // 1 1 2 2 3 3 4 4 5 5
    // | |     | |
    // | -----|--
    // --------
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        // 复制 next 连接
        RandomListNode curNode = pHead;
        while (curNode != null) {
            RandomListNode copyNode = new RandomListNode(curNode.label);
            copyNode.next = curNode.next;
            curNode.next = copyNode;
            curNode = curNode.next.next;
        }
        // 复制 random 连接
        curNode = pHead;
        while (curNode != null) {
            curNode.next.random = curNode.random == null ? null : curNode.random.next;
            curNode = curNode.next.next;
        }
        // 拆分链表
        RandomListNode resNode = pHead.next;
        curNode = pHead;
        while (curNode.next != null) {
            RandomListNode temp = curNode.next;
            curNode.next = temp.next;
            curNode = temp;
        }
        // 上面部分 我并未返回参数中的节点引用，只是没有将原链表还原，只是将新链表取出来，也判空
        return resNode;
    }
}
