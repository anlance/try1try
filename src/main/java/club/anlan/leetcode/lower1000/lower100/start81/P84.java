package club.anlan.leetcode.lower1000.lower100.start81;

import java.util.Stack;

public class P84 {
    public static void main(String[] args) {
        P84 p = new P84();
        int[] nums = {2,1,5,6,2,3};
        System.out.println(p.largestRectangleArea(nums));
    }

    // 返回最大的矩形面积
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len <= 0)
            return 0;
        if (len == 1)
            return heights[0];
        Stack<Integer> pos = new Stack<>();// 保存位置
        pos.add(-1);
        int maxArea = 0;
        for (int i = 0; i <= len; ++i) {
            int h = (i == len ? 0 : heights[i]);
            if (pos.peek() == -1 || heights[pos.peek()] <= h) {
                pos.add(i);
            } else {
                int tp = pos.peek();
                while (pos.peek() != -1 && heights[pos.peek()] > h) {
                    int curIndex = pos.pop();
                    int lastIndex = pos.peek();
                    maxArea = Math.max((tp - lastIndex) * heights[curIndex], maxArea);
                }
            }
            pos.add(i);
        }
        return maxArea;
    }
}
