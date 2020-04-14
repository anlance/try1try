package club.anlan.leetcode.lower1000.lower100.start61;

import java.util.regex.Pattern;

public class P65 {
    public static void main(String[] args) {
        P65 p = new P65();
        System.out.println(p.isNumber("-90e3"));
    }

    public boolean isNumber(String s) {
        String p1 = "[+-]?(([0-9]+\\.?[0-9]*)|([0-9]*\\.?[0-9]+))(e[+-]?[0-9]+)?";
        s = s.trim();
        return Pattern.matches(p1, s);
    }
}
