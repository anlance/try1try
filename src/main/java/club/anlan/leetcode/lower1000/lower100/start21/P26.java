package club.anlan.leetcode.lower1000.lower100.start21;

public class P26 {
    public static void main(String[] args) {
        P26 p = new P26();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(p.removeDuplicates(nums));
    }

    // 返回去除重复元素的数组（有序）的长度，（数组需要改变）前面的为单一元素
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        int index = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[index])
                continue;
            ++index;
            nums[index] = nums[i];
        }
        return (index + 1);
    }
}
