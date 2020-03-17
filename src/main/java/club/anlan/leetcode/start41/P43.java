package club.anlan.leetcode.start41;

import java.util.Arrays;

public class P43 {
    public static void main(String[] args) {
        P43 p = new P43();
        String num1 = "408";
        String num2 = "5";
        System.out.println(p.multiply(num1, num2));
    }

    // 返回 乘积 (模拟)
    public String multiply(String num1, String num2) {
        String res = "";
        if (num1.length() <= 0 || num2.length() <= 0)
            return res;
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0')
            return "0";
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int[] num = new int[Math.max(num1.length(), num2.length()) * 2 + 1];
        int index = 0;
        int len = num.length - 1;
        for (int i = num1.length() - 1; i >= 0; --i) {
            for (int j = num2.length() - 1; j >= 0; --j) {
                int temp = ((int) num1.charAt(i) - 48) * ((int) num2.charAt(j) - 48);
                index = len - ((len1 - i) + (len2 - j));

                num[index] += temp % 10;
                if (num[index] >= 10) {
                    num[index] -= 10;
                    num[index - 1] += 1;
                }
                num[index - 1] += temp / 10;
                if (num[index - 1] >= 10) {
                    num[index - 1] -= 10;
                    num[index - 2] += 1;
                }
            }
        }
        int start = index;
        start = num[index - 1] == 0 ? start : index - 1;
        start = num[index - 2] == 0 ? start : index - 2;
        for (int i = start; i < len + 1; ++i) {
            res += num[i];
        }
        return res;
    }
}
