package club.anlan.leetcode.start41;

public class P42 {
    public static void main(String[] args) {
        P42 p = new P42();
        int[] height = {5,2,1,2,1,5};
        System.out.println(p.trap(height));
    }

    // 给定一个数组，表示不同高度的木条，计算蓄水量
    public int trap(int[] height) {
        if (height.length < 3) // 长度小于 3，无蓄水可能
            return 0;
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        int maxHeight = 0;
        while (i <= j) {
            int temp = Math.min(height[i], height[j]);
            int len = j - i + 1;
            if (height[i] < height[j]) {
                res -= height[i];
                ++i;
            } else {
                res -= height[j];
                --j;
            }
            if (maxHeight < temp ) { // 当前高度大于最大高度，应当加上新面积
                res += len * (temp - maxHeight);
                maxHeight = temp;
            }
        }
        return res;
    }
}
