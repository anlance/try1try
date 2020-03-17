package club.anlan.leetcode.start41;

public class P44 {
    public static void main(String[] args) {
        P44 p = new P44();
        String ss = "mississippi";
        String pp = "m??*ss*?i*pi";
        System.out.println(p.isMatch(ss, pp));
    }
    //"mississippi"
    //"m??*ss*?i*pi"

    // 匹配字符串
    // 主要是对关于 * 号的匹配，
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 0; i < p.length(); ++i) {
            if (p.charAt(i) == '*')
                match[0][i + 1] = match[0][i];
        }
        // match[i][j] = match[i - 1][j] *匹配0个
        // match[i][j] = match[i][j - 1] *匹配多个
        // match[i][j] = match[i - 1][j - 1] *匹配1个
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j < p.length(); ++j) {
                if (p.charAt(j) == '*')
                    match[i + 1][j + 1] = match[i][j] || match[i + 1][j] || match[i][j + 1];
                else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
                    match[i + 1][j + 1] = match[i][j];
            }
        }
        return match[s.length()][p.length()];
    }


}
