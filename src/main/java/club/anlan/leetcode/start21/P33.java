package club.anlan.leetcode.start21;

public class P33 {
    public static void main(String[] args) {
        P33 p = new P33();
        int[] nums = {3, 1};
        System.out.println(p.search(nums, 1));
    }

    // 找到有序数组（根据某个点反转过）中 target 的位置
    // 只要涉及有序，就可以考虑二分
    public int search(int[] nums, int target) {
        int r = nums.length - 1;
        int l = 0;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (target == nums[mid]) { // 找到目标
                return mid;
            }
            if (nums[l] <= nums[mid]) { // 左边有序
                if (target > nums[mid]) { // 比中间大，肯定比左边大
                    l = mid + 1;
                } else {
                    if (target >= nums[l]) { // 比中间小，比左边大，肯定在左边了
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            } else { // 右边有序
                if (target < nums[mid]) { // 比中间小，肯定比右边小
                    r = mid - 1;
                } else {
                    if (target <= nums[r]) { // 比中间大，比右边小，肯定在右边了
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
