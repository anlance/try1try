package club.anlan.leetcode.start21;

import java.util.*;

public class P30 {
    public static void main(String[] args) {
        P30 p = new P30();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List list = p.findSubstring(s, words);
        list.forEach(i -> System.out.println(i));
    }
    //"a"
    //["a"]

    //"wordgoodgoodgoodbestword"
    //["word","good","best","word"]

    //"wordgoodgoodgoodbestword"
    //["word","good","best","good"]

    //"ababaab"
    //["ab","ba","ba"]

    //"aaaaaaaa"
    //["aa","aa","aa"]

    // "aaaaaa"
    //["aaa","aaa"]

    //"aaa"
    //["aa","aa"]

    //"lingmindraboofooowingdingbarrwingmonkeypoundcake"
    //["fooo","barr","wing","ding","wing"]

    // 找到字串的开头位置，每个字串必须包含数组中的每个字符串，并且中间不含其他字母
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() <= 0 || words.length <= 0 || words[0].length() <= 0)
            return res;
        // 滑动窗口 长度为 strLen * len
        int len = words.length;
        int strLen = words[0].length();


        Map<String, Integer> map = new HashMap<>(); // 存储字符串
        for (int i = 0; i < words.length; ++i) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        int l = 0;
        int r = strLen * len - 1;
        Map<String, Integer> tempMap = new HashMap();
        while (r < s.length()) {
            int index = l;
            // 初始化 map
            tempMap.clear();
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();
                tempMap.put(key, map.get(key));
            }
            while (index <= r ) {
                String str = s.substring(index, index + strLen);
                if (tempMap.containsKey(str)) {
                    if (tempMap.get(str) == 0)
                        break;
                    tempMap.put(str, tempMap.get(str) - 1);
                } else {
                    break;
                }
                // 内部起始位置移动
                index += strLen;
            }

            if (index == r + 1) {
                res.add(l);
            }
            // 外部起始位置 一定
            l++;
            r = strLen * len + l - 1;
        }
        return res;
    }
}
