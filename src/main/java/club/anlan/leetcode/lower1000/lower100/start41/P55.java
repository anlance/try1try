package club.anlan.leetcode.lower1000.lower100.start41;

public class P55 {
    public static void main(String[] args) {
        P55 p = new P55();
        int[] nums = {1,2,3};
        System.out.println(p.canJump(nums));
    }

    // 数组里是当前位置能跳的步数，判断是否能跳到最后一格
    public boolean canJump(int[] nums) {
        if(nums.length<=1)
            return true;
        int index = nums[0]; // 表示当前能到达的位置
        for (int i = 0; i < nums.length; ++i) {
            if(i>index)
                return false;
            if(i+nums[i]>=nums.length-1)
                return true;
            if(i+nums[i]>index)
                index=i+nums[i];
        }
        return false;
    }
}
