package club.anlan.leetcode.lower1000.lower100.start61;

import java.util.Arrays;

public class P66 {
    public static void main(String[] args) {
        P66 p = new P66();
        int[] dig = {9,9,9};
        int[] res = p.plusOne(dig);
        Arrays.stream(res).forEach(i-> System.out.print(i+" "));
    }

    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] += 1;
            return digits;
        }
        int[] res = new int[digits.length + 1];
        for (int j = digits.length - 1; j >= 0; --j) {
            if (digits[j] == 9) {
                digits[j] = 0;
                res[j + 1] = 0;
            } else {
                digits[j] += 1;
                return digits;
            }
        }
        res[0] = 1;
        return res;
    }
}
