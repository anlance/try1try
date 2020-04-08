package club.anlan.leetcode.start81;

public class P88 {
    public static void main(String[] args) {
        P88 p = new P88();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        p.merge(nums1,3,nums2,3);
        for (int i : nums1) {
            System.out.print(i+" ");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[index] = nums2[j];
                --j;
            } else {
                nums1[index] = nums1[i];
                --i;
            }
            --index;
        }
        while (j >= 0) {
            nums1[index] = nums2[j];
            --index;
            --j;
        }
    }
}
