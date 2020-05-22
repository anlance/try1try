package club.anlan.leetcode.lower1000.lower100.start1;

import java.util.*;

public class P16 {
    public static void main(String[] args) {
        P16 p = new P16();
        int[] nums = {1, 1, 1, 0};
        System.out.println(p.threeSumClosest(nums, -100));
    }

    // Q: 找到离目标值最近的三个数的和，返回和，（一定有解）
    public int threeSumClosest(int[] nums, int target) {
        // 对数组进行排序
        Arrays.sort(nums);
        int res = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        int min = Math.abs(target)+ res;
        for (int i = 0; i < nums.length - 1; ++i) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (target == sum) // 恰好等于 target
                    return sum;
                else if (target > sum) {
                    if (target - sum < min) {
                        res = sum;
                        min = target - sum;
                    }
                    ++l;
                } else {
                    if (sum - target < min) {
                        res = sum;
                        min = sum - target;
                    }
                    --r;
                }
            }
        }
        return res;
    }
}
