package club.anlan.leetcode.start41;

import java.util.Arrays;

public class P60 {
    public static void main(String[] args) {
        P60 p = new P60();
        System.out.println(p.getPermutation(2, 1));
        System.out.println(p.getPermutation(2, 2));

//        for(int i=1;i<25;++i){
//            System.out.println(p.getPermutation(4, i));
//
//        }

    }

    // 返回关于 1-n 形成的字符串的第 k（按照字典序） 个字符串
    // 3 3 -> 可形成 123 132 213 231....   ret=> 213
    public String getPermutation(int n, int k) {
        int[] res = new int[n];
        int[] methods = new int[n + 1];
        methods[0] = 1;
        methods[1] = 1;
        for (int i = 2; i < n + 1; ++i) { // 字符串的长度对应的排序总数
            methods[i] = i * methods[i - 1];
        }
        for (int i = 0; i < n; ++i) { // 保存数字的数组，用以交换后返回字符串
            res[i] = i + 1;
        }

        while (k > 0) {
            for (int i = 1; i <= n; ++i) {
                int temp = methods[i]; // 当前涉及的字符串长度对应的方法总数
                if (temp >= k) { // 找到被插入的位置（i）（从后往前）以及插入当前位置的数字的位置（index）
                    if(i==1){
                        k-=temp;
                        break;
                    }
                    temp = methods[i-1];
                    int index = k / temp;
                    if (k % temp != 0)
                        index += 1;
                    // 转移数字
                    int start = n - i;
                    int end = start + index - 1;
                    k -= temp*(index-1);

                    int number = res[end];
                    for (int j = end; j > start; --j) {
                        res[j] = res[j - 1];
                    }
                    res[start] = number;
                    break;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int a:res){
            ans.append(a);
        }
        return ans.toString();
    }
}
