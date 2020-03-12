package club.anlan.leetcode.start21;

public class P34 {
    public static void main(String[] args) {
        P34 p = new P34();
        int[] nums = {8,8,8,9};
        int[] res = p.searchRange(nums, 8);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    // 找到有序数组中 target 第一次和最后一次出现的位置
    // 二分二分
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums==null || nums.length<=0)
            return res;
        int l = 0;
        int r = nums.length - 1;
        if (target < nums[l] || target > nums[r]) // 特殊情况(target 在数组范围之外)，直接返回
            return res;
        int index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                index = mid;
                break;
            }
            if (target < nums[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        // 从该位置向左右扩展
        if (index != -1) {
            l = index;
            while (l >= 0) {
                if (nums[l] != target)
                    break;
                --l;
            }
            r = index;
            while (r < nums.length) {
                if (nums[r] != target)
                    break;
                ++r;
            }
            res[0] = l + 1;
            res[1] = r - 1;
        }
        return res;
    }
}
