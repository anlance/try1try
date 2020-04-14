package club.anlan.leetcode.lower1000.lower100.start61;

public class P80 {
    public static void main(String[] args) {
        P80 p = new P80();
//        int[] nums = {0,0,1,1,2,3,3};
        int[] nums = {1};
        System.out.println(p.removeDuplicates(nums));
        System.out.println("--------");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    // 最多重复 2 次
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int temp = nums[0];
        int count = 1;
        int len = nums.length;
        int index = -1;
        for (int i = 1; i < nums.length; ++i) {
            if (temp == nums[i]) {
                if (count == 1)
                    count++;
                else {
                    if (index == -1)
                        index = i;
                    nums[i] = Integer.MIN_VALUE;
                    len--;
                }
            } else {
                temp = nums[i];
                count = 1;
            }
        }
        if (index == -1)
            return len;
        int start = index + 1;
        for (int i = start; i < nums.length; ++i) {
            if (nums[i] != Integer.MIN_VALUE) {
                nums[index] = nums[i];
                nums[i] = Integer.MIN_VALUE;
                index += 1;
            }
        }
        return len;
    }
}
// 1 1 1 1 2 2 3
// 1 1 m m 2 3
// 1 1 2 m m 3
// 1 1 2 2 3 m
