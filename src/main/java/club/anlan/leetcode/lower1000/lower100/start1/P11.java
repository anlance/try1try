package club.anlan.leetcode.lower1000.lower100.start1;

public class P11 {
    public static void main(String[] args) {
        P11 p = new P11();
        int[] num = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(p.maxArea(num));
    }

    public int maxArea(int[] height) {
        if (height.length <= 1)
            return 0;
        int l = 0, r = height.length - 1;
        int max = -1;
        int left, right;
        int temp = 0;
        int length = 0;
        while (l <= r) {
            left = height[l];
            right = height[r];
            length = r - l;
            if (left > right) {
                temp = right;
                --r;
            } else {
                temp = left;
                ++l;
            }
            max = Math.max(max, temp * length);
        }
        return max;
    }
}
