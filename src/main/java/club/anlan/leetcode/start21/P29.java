package club.anlan.leetcode.start21;

public class P29 {
    public static void main(String[] args) {
        P29 p = new P29();
        System.out.println(p.divide(2147483647, -1));
    }
    //-1010369383
    //-2147483648

    // 不能使用 % / * 完成 / 操作
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        // 用减法可以完成
        boolean isSide = false;
        int res = 0;
        // 对于 Integer.MIN_VALUE 特殊处理
        if(divisor==Integer.MIN_VALUE){
            if(dividend==Integer.MIN_VALUE)
                return 1;
            return 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            if(divisor==1)
                return Integer.MIN_VALUE;
            else if(divisor==-1)
                return Integer.MAX_VALUE;
            if (divisor < 0) {
                dividend -= divisor;
            } else {
                dividend += divisor;
            }
            res += 1;
        }

        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            isSide = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            res += 1;
            dividend -= divisor;
        }
        return isSide ? res : -res;
    }
}
