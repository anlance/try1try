package club.anlan.leetcode.start61;

public class P76 {
    public static void main(String[] args) {
        P76 p = new P76();
    }

    // 返回 s 中包含 t中所有元素 的最小字符串
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (int i = 0; i < t.length(); ++i) {
            map[t.charAt(i)] += 1;
        }

        int begin = 0;
        int len = Integer.MAX_VALUE;
        int count = t.length();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            --map[c];
            if (map[c] >= 0)
                --count;
            while (count == 0) { // 开始进行一轮扩展并收缩
                char lc = s.charAt(left);
                ++map[lc];
                if (map[lc] > 0) {
                    if (right - left + 1 < len) {
                        begin = left;
                        len = right - left + 1;
                    }
                    ++count;
                }
                ++left;
            }

            ++right;
        }
        return len==Integer.MAX_VALUE?"":s.substring(begin, begin+len);
    }
}
