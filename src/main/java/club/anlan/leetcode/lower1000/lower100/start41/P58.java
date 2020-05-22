package club.anlan.leetcode.lower1000.lower100.start41;

public class P58 {
    public static void main(String[] args) {
        P58 p = new P58();
        String s = "Hello ";
        System.out.println(p.lengthOfLastWord(s));

    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() <= 0)
            return 0;
        s = s.trim();
        int r = s.length() - 1;
        while (r > 0) {
            if (s.charAt(r) == ' ') {
                break;
            }
            --r;
        }
        return r == 0 ? s.length()  : s.length() - r - 1;
    }
}
