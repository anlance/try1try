package club.anlan.leetcode.lower1000.lower100.start61;

public class P69 {
    public static void main(String[] args) {
        P69 p = new P69();
        for(int i=1;i<20;++i){
            int x = i;
            System.out.println(p.mySqrt(x)+":"+i);
        }
    }

    // 实现开方
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int l = 1;
        int r = x;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid <= x / mid) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
