package club.anlan.leetcode;

import java.util.Arrays;

public class P4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    // Q: 算出两个有序数组的中位数。
    // A: 笨方法：将两个有序数组放进一个数组，然后来获得中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0.0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        int len = l1 + l2;
        int[] num = new int[len];
        int i = 0, j = 0, index = 0;
        while (i < l1 || j < l2) {
            if (i >= l1) {
                num[index] = nums2[j];
                ++j;
            } else if (j >= l2) {
                num[index] = nums1[i];
                ++i;
            } else if (nums1[i] > nums2[j]) {
                num[index] = nums2[j];
                ++j;
            } else {
                num[index] = nums1[i];
                ++i;
            }
            ++index;
        }
        res = len % 2 == 0 ? (double) (num[len / 2] + num[len / 2 - 1]) / 2 : num[len / 2];
        return res;
    }
}
