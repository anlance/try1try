package club.anlan.leetcode.start1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P20 {
    public static void main(String[] args) {
        P20 p = new P20();
        String s = "([)]";
        System.out.println(p.isValid(s));
    }

    // 括号匹配
    public boolean isValid(String s) {
        // 根据长度直接排除一些
        if(s.length()%2!=0)
            return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        List<Character> list = new ArrayList<>();

        for(int i=0;i<s.length();++i){
            if(map.containsKey(s.charAt(i))){
                list.add(s.charAt(i));
            } else {
                if(list.size()==0)
                    return false;
                else if(s.charAt(i)!=map.get(list.get(list.size()-1)))
                    return false;
                else{
                    list.remove(list.size()-1);
                }
            }
        }
        return list.size()==0;
    }
}
