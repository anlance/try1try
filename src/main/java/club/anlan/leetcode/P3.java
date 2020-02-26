package club.anlan.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        while (num > 0) {
//            String str = sc.next();
//            num--;
//        }
        String str = sc.next();
        System.out.println(lengthOfLongestSubstring(str));

    }

    // 1.遍历整个字符串，将经过的字符与该字符的位置存在 map 里
    // 2.当查找到有相同的字母出现时，取此时字串的长度与最大值进行比较并取较大值
    public static int lengthOfLongestSubstring(String s) {
        return lengthOfOne(s, 0);
    }

    public static int lengthOfOne(String s, int start) {
        Map map = new HashMap<Character, Integer>();
        int nIndex = 0;
        int sameIndex = 0;
        for (int i = start; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                nIndex = (int) map.get(s.charAt(i));
                sameIndex = i;
                map.clear();
                break;
            }
            map.put(s.charAt(i), i);
        }
        if (sameIndex != 0) {
            return Math.max(sameIndex - start, lengthOfOne(s, nIndex + 1));
        }
        return s.length() - start;
    }
}
