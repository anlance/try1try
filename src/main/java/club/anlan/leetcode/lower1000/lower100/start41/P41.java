package club.anlan.leetcode.lower1000.lower100.start41;

public class P41 {
    public static void main(String[] args) {
        P41 p = new P41();
        int[] nums = {7,8,9,11,12};
        System.out.println(p.firstMissingPositive(nums));
    }

    // 找到缺失的最小正整数
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 1;
        boolean[] temp = new boolean[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= temp.length && nums[i] > 0)
                temp[nums[i] - 1] = true;

        }
        for (int i = 0; i < temp.length; ++i) {
            if (!temp[i])
                return i + 1;
        }
        return temp.length + 1;
    }
}
