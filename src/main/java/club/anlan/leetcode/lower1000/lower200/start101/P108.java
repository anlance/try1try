package club.anlan.leetcode.lower1000.lower200.start101;

import java.util.Arrays;

public class P108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int l = 0;
        int r = nums.length;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if(mid>0)
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        if(mid+1<nums.length)
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return root;
    }
}
