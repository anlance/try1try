package club.anlan.leetcode.lower1000.lower100.start41;

public class P53 {
    public static void main(String[] args) {
        P53 p = new P53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(p.maxSubArray(nums));
    }

    // 返回数组中连续得最大和
    public int maxSubArray(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        int res = ans[0];
        for (int i = 1; i < nums.length; ++i) {
            ans[i] = Math.max(nums[i], nums[i] + ans[i - 1]);
            if (ans[i] > res)
                res = ans[i];
        }
        return res;
    }

}
