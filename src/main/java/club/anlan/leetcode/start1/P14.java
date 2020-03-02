package club.anlan.leetcode.start1;

public class P14 {
    public static void main(String[] args) {
        P14 p = new P14();
        String[] strs = {"dog","racecar","car"};
        System.out.println(p.longestCommonPrefix(strs));
    }

    // 找到最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        // 数组长度为 0
        if (strs.length <= 0)
            return "";
        int index = 0;
        boolean isOver = false;
        for (int i = 0; ; ++i) {
            // 第一个字符串遍历完
            if (i >= strs[0].length()) {
                break;
            }
            // 取出当前字符用于比较
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                // 若遍历完当前字符串 或者 当前位置字符不想同时
                if (i >= strs[j].length() || temp != strs[j].charAt(i)) {
                    isOver = true;
                    break;
                }
            }
            if (isOver) {
                index = i;
                break;
            }
        }
        if(!isOver)
            index = strs[0].length();
        return index == 0 ? "" : strs[0].substring(0, index);
    }
}
