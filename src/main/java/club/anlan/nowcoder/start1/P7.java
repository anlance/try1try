package club.anlan.nowcoder.start1;

public class P7 {
    public static void main(String[] args) {
        P7 p = new P7();
        System.out.println(p.Fibonacci(5));
    }

    // 斐波那契数列
    public int Fibonacci(int n) {
        if (n <= 1)
            return n;
        int a=0,b=1;
        int res = -1;
        n-=1;
        while (n>0){ // 利用 a b 而不是数组 减少存储
            n--;
            res = a+b;
            a=b;
            b=res;
        }
        return res;
    }
}
