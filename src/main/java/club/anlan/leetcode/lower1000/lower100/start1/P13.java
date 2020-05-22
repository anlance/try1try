package club.anlan.leetcode.lower1000.lower100.start1;

import java.util.HashMap;
import java.util.Map;

public class P13 {
    public static void main(String[] args) {
        P13 p = new P13();
        System.out.println(p.romanToInt("MCMXCIV"));

    }

    // 存进 map 取出来相加即可，只是需要先判断是否是那 6 种特殊情况
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        int res = 0;
        int index = 0;
        while (index < s.length()) {
            if (index + 1 < s.length()) {
                String temp = s.substring(index, index + 2);
                if (map.containsKey(temp)) {
                    res += map.get(temp);
                    index += 2;
                    continue;
                }
            }
            res += map.get(s.substring(index, index + 1));
            ++index;
        }
        return res;
    }
}
