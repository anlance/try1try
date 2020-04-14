package club.anlan.leetcode.lower1000.lower100.start21;

import java.util.Stack;

public class P32 {
    public static void main(String[] args) {
        P32 p = new P32();
        String s = "(()())";
        System.out.println(p.longestValidParentheses(s));
    }

    // 找到最长的符合匹配的
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        stack.push(-1);
        while (index < s.length()) {
            if (s.charAt(index) == '(')
                stack.push(index);
            else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(index);
                } else {
                    max = Math.max(max, index - stack.peek());
                }
            }
            ++index;
        }
        return max;
    }
}
