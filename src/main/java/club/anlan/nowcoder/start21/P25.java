package club.anlan.nowcoder.start21;

public class P25 {

    // 常规做法————————超时
    // 可优化的地方，利用 map 来 存放 节点对应的 random 节点，这样就不至于每次从头点来找 random 节点

    // 复杂链表的复制
    // 输入一个复杂链表
    // （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
    // 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode resHead = new RandomListNode(pHead.label);
        RandomListNode curResNode = resHead;
        RandomListNode curPNode = pHead;
        // 构建整个 Next 链表
        while (curPNode.next != null) {
            curPNode = curPNode.next;
            curResNode.next = new RandomListNode(curPNode.label);
            curResNode = curResNode.next;
        }
        // 构建 random 链表
        curPNode = pHead;
        curResNode = resHead;
        while (curPNode != null) {
            RandomListNode temp = null;
            if (curPNode.random != null)
                temp = curPNode.random.next;
            else
                continue;
            RandomListNode cpNode = pHead;
            RandomListNode crNode = resHead;
            while (cpNode != null) { // 从头结点开始遍历 找到 随机节点 random
                if (cpNode.next == temp) {
                    curResNode.random = crNode;
                    break;
                }
                cpNode = cpNode.next;
                crNode = crNode.next;
            }
            curPNode = curPNode.next;
            curResNode = curResNode.next;
        }
        return resHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}