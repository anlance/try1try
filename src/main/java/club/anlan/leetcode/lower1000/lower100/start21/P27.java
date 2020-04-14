package club.anlan.leetcode.lower1000.lower100.start21;

import java.util.Arrays;

public class P27 {
    public static void main(String[] args) {
        P27 p = new P27();
        int[] nums = {3,2,2,3};
        System.out.println(p.removeElement(nums, 3));
        Arrays.stream(nums).forEach(i -> System.out.println(i));
    }

    // 移除数组中所有值为 val ，并返回数组的长度（无 val）
    // 可增加窗口大小的滑动窗口，还可以进一步优化，val 可以形成一个增加的窗口，非 val 可以形成一个变动的窗口
    public int removeElement(int[] nums, int val) {
        int i = -1, j = 0;
        int length = 0;
        while (j < nums.length) {
            if (val == nums[j]) {
                if (i == -1) {
                    i = j; // 初始化第一个元素为 val 的位置
                }
            } else {
                ++length;
                if (i != -1) {
                    int temp = nums[j];
                    for (int k = j; k > i; --k) {
                        nums[k] = nums[k - 1];
                    }
                    nums[i] = temp;
                    i += 1;
                }
            }
            ++j;
        }
        return length;
    }
}
