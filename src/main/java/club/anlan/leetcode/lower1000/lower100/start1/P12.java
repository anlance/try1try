package club.anlan.leetcode.lower1000.lower100.start1;

public class P12 {
    public static void main(String[] args) {
        P12 p = new P12();
        System.out.println(p.intToRoman(1994));
    }

    // 数字转罗马字符串
    // 6 种特殊情况 : 4 9 40 90 400 900
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] dig = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // 特殊情况

        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < nums.length; ++i) {
            // 个数
            int number = num / nums[i];
            for (int j = 0; j < number; ++j) {
                res.append(dig[i]);
            }
            num = num % nums[i];
        }
        return res.toString();
    }

}
