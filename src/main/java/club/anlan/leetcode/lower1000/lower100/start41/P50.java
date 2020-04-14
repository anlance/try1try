package club.anlan.leetcode.lower1000.lower100.start41;

public class P50 {
    public static void main(String[] args) {
        P50 p = new P50();
        double x = 2;
        int n = -2;
        double res = p.myPow(x, n);
        System.out.println(res);
    }

    public double myPow(double x, int n) {
        return n > 0 ? myPow2(x, n) : 1 / myPow2(x, -n);
    }

    public double myPow2(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n == 1)
            return x;
        if (n % 2 == 0)
            return myPow2(x * x, n / 2);
        else
            return myPow2(x * x, n / 2) * x;
    }
}
