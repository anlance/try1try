package club.anlan.nowcoder.start21;


import java.util.Stack;

public class P21 {
    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {1, 2, 3, 4, 5};
        P21 p = new P21();
        System.out.println(p.IsPopOrder(pushA, popA));
    }

    // 栈的压入、弹出序列
    //输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
    // 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
    // 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
    // （注意：这两个序列的长度是相等的）
    // 滑动窗口来（针对 pushA）
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushA.length || j < popA.length) {
            if (i < pushA.length && pushA[i] != popA[j]) {
                stack.push(pushA[i]);
                ++i;
            } else {
                if (i < pushA.length && pushA[i] == popA[j]) {
                    ++i;
                } else if (stack.isEmpty() || popA[j] != stack.pop()) {
                    return false;
                }
                ++j;
            }
        }
        return stack.isEmpty();
    }
}
