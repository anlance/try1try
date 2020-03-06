package club.anlan.leetcode.start21;

import java.util.ArrayList;
import java.util.List;

public class P22 {

    public static void main(String[] args) {
        P22 p = new P22();
        List list = p.generateParenthesis(3);
        list.forEach(i -> System.out.println(i));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, "", 0, 0, n * 2);
        return res;
    }

    public void backTrack(List<String> res, String s, int open, int close, int length) {
        if (s.length() == length) {
            res.add(s);
            return;
        }
        if (open < length / 2)
            backTrack(res, s + "(", open + 1, close, length);
        if (close < open)
            backTrack(res, s + ")", open, close + 1, length);
    }
}
