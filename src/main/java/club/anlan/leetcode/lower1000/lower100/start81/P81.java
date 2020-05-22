package club.anlan.leetcode.lower1000.lower100.start81;

public class P81 {
    public static void main(String[] args) {
        P81 p = new P81();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int[] temp = {3, 1};
        for (int i = 0; i < 10; ++i) {
            System.out.println(i + ":" + p.search(nums, i));
        }
        System.out.println(p.search(temp, 1));
        System.out.println(p.search(temp, 3));
    }

    // 经过翻转一次的有序数组中寻找 target
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length <= 0)
            return false;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid])
                return true;
            else if (nums[mid] > nums[r]) { // 左边有序
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[l] > mid) {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target == nums[l])
                    return true;
                else
                    l++;
            }
        }
        return false;
    }
}
