package club.anlan.leetcode.lower1000.lower100.start61;

import java.util.Arrays;

public class P75 {
    public static void main(String[] args) {
        P75 p = new P75();
        int[] arr = {2, 0, 2, 1, 1, 0};
        p.sortColors(arr);
        Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
    }

    // 排序 (只有 0 1 2 三种数字)
    public void sortColors(int[] nums) {
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (0 == nums[i])
                ++num0;
            else if (1 == nums[i])
                ++num1;
            else
                ++num2;
        }
        int k = 0;
        num1 += num0;
        num2 += num1;
        while (k < num0) {
            nums[k] = 0;
            ++k;
        }
        while (k < num1) {
            nums[k] = 1;
            ++k;
        }
        while (k < num2) {
            nums[k] = 2;
            ++k;
        }
    }
}
