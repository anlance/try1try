package club.anlan.leetcode.start1;

import java.util.*;

public class P17 {
    public static void main(String[] args) {
        P17 p = new P17();
        String digits = "23";
        List list = p.letterCombinations(digits);
        list.forEach(System.out::println);
    }

    // 2 -> a b c
    // 3 -> d e f
    // ....
    // 7 -> p q r s
    // ....
    // 9 -> w x y z
    // 只有一个一个加的笨方法
    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0)
            return new ArrayList<>();

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new LinkedList<>();
        res.add("");
        for (int i = 0; i < digits.length(); ++i) {

            String temp = map.get(digits.charAt(i));

            // 增添一个数字的情况
            List<String> tempRes = new LinkedList<>();
            for (int j = 0; j < res.size(); ++j) {
                String old = res.get(j);
                for (int k = 0; k < temp.length(); ++k) {
                    String str = old + temp.charAt(k);
                    tempRes.add(str);
                }
            }
            res.clear();
            res.addAll(tempRes);
            tempRes.clear();
        }
        return res;
    }
}
