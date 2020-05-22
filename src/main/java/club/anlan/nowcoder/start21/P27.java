package club.anlan.nowcoder.start21;

import java.util.*;

public class P27 {

    // 深搜全排列 很有参考
    public static void main(String[] args) {
        P27 p = new P27();
        String s = "aabcd";
        ArrayList list = p.Permutation(s);
        Collections.sort(list);
        list.forEach(i -> System.out.println(i));
    }
    //字符串的排列

    // 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
    // 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
    public ArrayList<String> Permutation(String str) {
        if(str==null || str.length()<=0)
            return new ArrayList<>();
        // 排序
        Map<Character, Character> map = new HashMap<>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        ArrayList res = new ArrayList();
        char[] cur = new char[chars.length+1];
        boolean[] visited = new boolean[chars.length+1];
        Set<String> set = new HashSet<>();
        dfs(0,chars.length,res,chars,cur,visited,set);
        return res;
    }

    public void dfs(int index, int len, ArrayList<String> list, char[] chars,char[] cur,boolean[] visited,Set<String> set) {
        if (index == len) {
            String temp = "";
            for (int i = 0; i < len; ++i) {
                temp += cur[i];
            }
            if(!set.contains(temp)){
                list.add(temp);
                set.add(temp);
            }
            return;
        }
        for(int i=1;i<=len;++i){
            if(!visited[i]){
                visited[i]=true;
                cur[index]=chars[i-1];
                dfs(index+1,len,list,chars,cur,visited, set);
                visited[i]=false;
            }
        }
    }

}
