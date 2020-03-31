package club.anlan.leetcode.start61;

import java.util.LinkedList;
import java.util.List;

public class P71 {
    public static void main(String[] args) {
        P71 p = new P71();
        String path = "/a//b////c/d//././/..";
        System.out.println(p.simplifyPath(path));
    }

    // 字符串处理
    public String simplifyPath(String path) {
        if (path == null || path.length() <= 1)
            return "/";
        List<String> list = new LinkedList<>();
        int start = 0;
        for (int i = 1; i < path.length(); ++i) {
            if (path.charAt(i) == '/' || i == path.length() - 1) {
                if (i == path.length() - 1 && path.charAt(i) != '/')
                    i += 1;
                String str = path.substring(start, i);
                if ("/..".equals(str)) {
                    if (!list.isEmpty())
                        list.remove(list.size() - 1);
                } else if (!"/.".equals(str) && !"/".equals(str))
                    list.add(str);
                start = i;
            }
        }
        if (list.isEmpty())
            return "/";
        String res = "";
        for (String temp : list)
            res += temp;
        return res;
    }

}
