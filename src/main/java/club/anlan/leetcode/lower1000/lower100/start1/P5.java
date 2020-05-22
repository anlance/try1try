package club.anlan.leetcode.lower1000.lower100.start1;

public class P5 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(manache(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        // 使用中心扩展
        int end = 0, start = 0;
        for (int i = 0; i < s.length(); ++i) {
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                end = i + len / 2;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // 中心扩展
    public static int expandCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    // 马拉车算法


    public static String manache(String s) {
        String t = preProcess(s);
        int len = t.length();
        int[] p = new int[len];

        int center = 0, radius = 0;
        for (int i = 1; i < t.length()-1; ++i) {
            int i_mirror = center * 2 - i;
            if (radius > i) { // 大于了半径，先置为较小值，然后利用中心扩展进行扩展
                p[i] = Math.min(radius - i, p[i_mirror]);
            } else { // 等于 radius, 先置为 0 ，然后利用中心扩展进行扩展
                p[i] = 0;
            }

            // 中心扩展
            while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                ++p[i];
            }

            // 是否需要更新 radius
            if (i + p[i] > radius) {
                center = i;
                radius = i + p[i];
            }
        }

        int maxLen = 0;
        int curIndex = 0;
        for (int i = 1; i < len - 1; ++i) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                curIndex = i;
            }
        }
        int start = (curIndex - maxLen) / 2; //最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }

    public static String preProcess(String s) {// 预处理
        if (s.length() == 0) {
            return "^$";
        }
        String res = "^";
        for (int i = 0; i < s.length(); ++i) {
            res += "#" + s.charAt(i);
        }
        res += "#$";
        return res;
    }
}
