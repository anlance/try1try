package club.anlan.leetcode.lower1000.lower100.start21;

public class P35 {
    public static void main(String[] args) {
        P35 p = new P35();
        int nums[] = {1,3,5,6};
        System.out.println(p.searchInsert(nums,0));
    }

    // 如果存在，返回位置，   若不存在，返回将插入的位置
    // 有序数组，不二分还愣着干嘛
    public int searchInsert(int[] nums, int target) {
        if (nums.length <= 0)
            return 0;
        int l = 0;
        int r = nums.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) { // 找到 target
                index = mid;
                break;
            }
            if (target > nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        if(index!=-1)
            return index;
        if(l==nums.length)
            return nums.length;
        // l 和 r 此时相等
        return target>nums[l]?l+1:l;
    }
}
