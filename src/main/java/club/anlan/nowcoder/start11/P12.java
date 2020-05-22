package club.anlan.nowcoder.start11;


public class P12 {
    public static void main(String[] args) {
        P12 p = new P12();
        System.out.println(p.Power(3.0,-2));
    }

    // 数值的整数次方
    //给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    //保证base和exponent不同时为0
    public double Power(double base, int exponent) {
        if(base==0)
            return 0.0;
        if(exponent==0)
            return 1.0;
        if(exponent<0){
            exponent = -exponent;
            base = 1.0 / base;
        }
        double res = base;
        while (exponent>1){
            res*=base;
            --exponent;
        }
        return res;
    }
}
