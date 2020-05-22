package club.anlan.leetcode.lower1000.lower100.start81;

import java.util.ArrayList;
import java.util.List;

public class P93 {
    public static void main(String[] args) {
        P93 p = new P93();
        String s = "11111111111111111111111111111111";
        List<String> res = p.restoreIpAddresses(s);
        res.forEach(i -> System.out.println(i));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() >= 12)
            return res;
        dfs(res, new ArrayList<>(), s, 0, 0);
        return res;
    }

    public void dfs(List<String> res, List<String> list, String s, int index, int number) {
        if (number == 4) {
            String str = "";
            int len = 0;
            for (String temp : list) {
                str += temp + ".";
                len += temp.length();
            }
            if (len == s.length())
                res.add(str.substring(0, str.length() - 1));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            // 1
            list.add(s.substring(i, i + 1));
            dfs(res, list, s, i + 1, number + 1);
            list.remove(list.size() - 1);
            // 2
            if (i + 1 < s.length() && s.charAt(i) != '0') {
                list.add(s.substring(i, i + 2));
                dfs(res, list, s, i + 2, number + 1);
                list.remove(list.size() - 1);
            }
            // 3
            if (i + 2 < s.length() && '1' <= s.charAt(i) && s.charAt(i) <= '2') {
                if (s.charAt(i) == '1' || s.charAt(i + 1) <= '4' || (s.charAt(i + 1) == '5' && s.charAt(i + 2) <= '5')) {
                    list.add(s.substring(i, i + 3));
                    dfs(res, list, s, i + 3, number + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
