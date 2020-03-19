package club.anlan.nowcoder.start31;

// 整数中1出现的次数（从1到n整数中1出现的次数）
public class P31 {
    public static void main(String[] args) {
        P31 p = new P31();
        System.out.println(p.NumberOf1Between1AndN_Solution(13));
    }

    // 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
    // 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
    // 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
    // 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        if (n <= 0)
            return res;
        for (int i = 1; i <= n; i *= 10) {
            int diviver = i * 10;
            res += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return res;
    }
}
