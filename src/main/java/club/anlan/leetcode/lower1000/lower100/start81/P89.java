package club.anlan.leetcode.lower1000.lower100.start81;

import java.util.ArrayList;
import java.util.List;

public class P89 {
    public static void main(String[] args) {
        P89 p = new P89();
        List<Integer> res = p.grayCode(2);
        res.forEach(i-> System.out.print(i+" "));
    }
    // two successive values differ in only one bit.
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        for(int i = 0; i < 1 << n; ++ i)
            res.add(i ^ i >> 1);
        return res;
    }
}
