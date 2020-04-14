package club.anlan.leetcode.lower1000.lower100.start61;

import java.util.ArrayList;
import java.util.List;

public class P68 {
    public static void main(String[] args) {
        P68 p = new P68();
        String[] words = {"Science"};
        List<String> res = p.fullJustify(words, 20);
        res.forEach(i -> System.out.println(i));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = 0; // 字符串个数
        int m = 0; // 空格长度
        int len = 0; // 当前字符串总长度
        List<String> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int i = 0;
        int index = -1;
        while (i < words.length) {
            String temp = words[i];
            n += 1;
            list.add(temp);
            len += temp.length();
            if (len + n - 1 > maxWidth) { //找到一行
                // 移除上一个字符串
                len -= temp.length();
                list.remove(list.size() - 1);
                n -= 1;
                i -= 1;

                m = maxWidth - len;
                String str = "";
                int spaceNum = -1;

                if (n == 1) { //生成一行(只有一个字符)
                    str += list.get(0);
                    spaceNum = m;
                    String space = "";
                    while (spaceNum > 0) {
                        --spaceNum;
                        space += " ";
                    }
                    str += space;
                    n -= 1;
                }
                while (n > 0) { // 生成一行(不止一个字符)
                    str = list.get(n - 1) + str;
                    if (n == 1) {
                        spaceNum = m;
                    } else {
                        spaceNum = m / (n - 1);
                    }
                    m -= spaceNum;
                    --n;
                    String space = "";
                    while (spaceNum > 0) {
                        --spaceNum;
                        space += " ";
                    }
                    str = space + str;
                }
                res.add(str);
                list.clear();
                len = 0;
                n = 0;
                index = i;
            }
            i += 1;
        }
        String str = "";
        for(i =index+1;i<words.length;++i){ // 最后一排
            if(i==words.length-1){
                str+=words[i];
            } else {
                str+=words[i]+" ";
            }
        }
        int spaceNum = maxWidth-str.length();
        for(i=0;i<spaceNum;++i){
            str+=" ";
        }
        res.add(str);
        return res;
    }
}
