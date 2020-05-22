package club.anlan.leetcode.lower1000.lower100.start41;

import java.util.*;

public class P49 {
    public static void main(String[] args) {
        P49 p = new P49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List list = p.groupAnagrams(strs);
        list.forEach(i -> System.out.println(i));
    }

    // 把字母相同得放进一个 list 中
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length <= 0)
            return res;
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < strs.length; ++i) {

            char[] temp = new char[strs[i].length()];
            for (int j = 0; j < strs[i].length(); ++j) {
                temp[j] = strs[i].charAt(j);
            }
            Arrays.sort(temp);
            String str = "";
            for(int j=0;j<temp.length;++j){
                str+=temp[j];
            }

            if (map.containsKey(str)) { // 已存在字符相同得字符串
                res.get(map.get(str)).add(strs[i]);
            } else { // 第一次
                map.put(str, index);
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                res.add(list);
                ++index;
            }
        }
        return res;
    }
}
