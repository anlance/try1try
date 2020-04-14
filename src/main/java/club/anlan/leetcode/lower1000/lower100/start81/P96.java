package club.anlan.leetcode.lower1000.lower100.start81;

import java.util.HashMap;
import java.util.Map;

public class P96 {

    public static void main(String[] args) {
        P96 p = new P96();
        System.out.println(p.numTrees(4));
    }

    Map<Integer,Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int result = 0;
        for(int i = 1;i<=n;i++){
            int left = numTrees(i-1);
            int right = numTrees(n-i);
            result += (left * right);
        }
        map.put(n,result);
        return result;
    }
}
