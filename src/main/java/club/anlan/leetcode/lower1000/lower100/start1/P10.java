package club.anlan.leetcode.lower1000.lower100.start1;


// 逻辑应该没问题了，只是会超时
public class P10 {
    public static void main(String[] args) {
        P10 p = new P10();
        String ss = "";
        String pp = ".*.*.*.*.*.*.*";
        System.out.println(p.isMatch(ss, pp));
    }


    public boolean isMatchOne(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length())
            return true;
        // 必须先判断特殊情况 ，比如 s 和 p 都是 *
        if (i < s.length() && j < p.length()) {
            if (p.charAt(j) == '.') { // . 匹配当前位置
                if (j + 1 < p.length() && p.charAt(j + 1) == '*')
                    return isMatchOne(s, p, i, j + 2) || isMatchOne(s, p, i + 1, j + 1); // 同时去掉当前字符和*符号
                return isMatchOne(s, p, i + 1, j + 1);
            } else if (p.charAt(j) == '*') { // * 匹配当前位置 或者不匹配
                // 第一个为 * 时只能空匹配
                if (i == 0)
                    return isMatchOne(s, p, i, j + 1);
                // * 匹配 0次或者多次
                return ((isMatchOne(s, p, i + 1, j) || isMatchOne(s, p, i + 1, j + 1)) && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)))
                        || isMatchOne(s, p, i, j + 1) // * 匹配一次
                        || isMatchOne(s, p, i - 1, j + 1); // * 匹配 0次
            } else if (s.charAt(i) == p.charAt(j)) {
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') //就算相同也可能跳过
                    return isMatchOne(s, p, i, j + 2) || isMatchOne(s, p, i + 1, j + 1); // 同时去掉当前字符和下一个*符号
                return isMatchOne(s, p, i + 1, j + 1);

            } else { // 不同时，下一个必须是*来 0 重复才有可能匹配（* 匹配 0 次）
                if (j + 1 < p.length() && p.charAt(j + 1) == '*')
                    return isMatchOne(s, p, i, j + 2); // 同时去掉当前字符和下一个*符号
                return false;
            }
        } else if (j < p.length()) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*')
                ++j;
            while (j < p.length() && p.charAt(j) == '*') {
                ++j;
            }
            return j == p.length();
        }
        // p 已经匹配完而 s 还有未匹配
        return false;
    }

    // 递归来处理（主要是 * 可以匹配可以不匹配）
    public boolean isMatch(String s, String p) {
        if (s.isEmpty() || p.isEmpty()) {
            if(p.length()==1)
                return false;
            if (s.isEmpty()) {
                for (int i = 0; i < p.length(); ++i) {
                    if (p.charAt(i) != '*')
                        if(i+1<p.length() && p.charAt(i+1)!='*')
                            return false;
                }
                return true;
            }
            // s 为空 ， p不为空
            return false;
        }
        return isMatchOne(s, p, 0, 0);
    }
}
