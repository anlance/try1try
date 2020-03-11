package club.anlan.leetcode.start21;

import java.util.Arrays;

public class P31 {
    public static void main(String[] args) {
        P31 p = new P31();
        int[] nums = {1, 3, 2};
        p.nextPermutation(nums);
        Arrays.stream(nums).forEach(i -> System.out.println(i));
    }

    // 返回当前字典序的下一个排列，若没有 则返回最小的排列
    // 由于是整数，可以不用全排序的做法
    public void nextPermutation(int[] nums) {
        // 从后往前遍历整个数组，找到 比数组后方元素小的(距离最小)
        boolean isMax = true;
        int max = nums[nums.length - 1];
        int l = 0;
        int r = nums.length - 1;
        for (int i = nums.length - 1; i > -1; --i) {
            if (nums[i] < max) {
                l = i;
                isMax = false;
                break;
            } else {
                max = nums[i];
                r = i; // 此时的 r 不一定是准确的 r
            }
        }
        //当前数组为最大排列
        if (isMax) {
            r = nums.length - 1;
            while (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                ++l;
                --r;
            }
            return;
        }
        int min = nums[r];
        for (int i = r + 1; i < nums.length; ++i) {
            if (nums[i] > nums[l] && nums[i] < min) {
                min = nums[i];
                r = i; // 找到准确的交换位置
            }
        }
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        Arrays.sort(nums,l+1,nums.length);
    }
}
