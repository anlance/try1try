package club.anlan.leetcode.lower1000.lower100.start1;

public class P7 {
    public static void main(String[] args) {
        P7 p = new P7();
        int x = -123;
        System.out.println(p.reverse(x));
//        System.out.println(Integer.MAX_VALUE);
    }

    public int reverse(int x) {
        if (x == 0)
            return 0;
        // 判断正负性
        boolean isNeg = x < 0;
        String temp = String.valueOf(x);
        String reversStr;
        // 将 '-' 号抽离出
        if (isNeg) {
            reversStr = new StringBuilder(temp.substring(1)).reverse().toString();
        } else {
            reversStr = new StringBuilder(temp).reverse().toString();
        }
        int index = 0;
        while (index < reversStr.length() && reversStr.charAt(index) == '0') {
            ++index;
        }
        String str = reversStr.substring(index);
        // 溢出 返回 0
        String maxStr = "2147483647";
        if (str.length() >= 10) {
            if (str.length() > 10)
                return 0;
            else if (str.compareTo(maxStr) > 0)
                return 0;
        }
        int res = 0;
        if (isNeg) {
            res = Integer.parseInt("-" + str);
        } else {
            res = Integer.parseInt(str);
        }
        return res;
    }
}
