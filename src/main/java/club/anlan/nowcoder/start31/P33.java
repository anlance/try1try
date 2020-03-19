package club.anlan.nowcoder.start31;

import java.util.Arrays;

// 丑数
public class P33 {
    public static void main(String[] args) {
        P33 p = new P33();
        System.out.println(p.GetUglyNumber_Solution(7));
    }

    // 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
    // 例如6、8都是丑数，但14不是，因为它包含质因子7。
    // 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
    public int GetUglyNumber_Solution(int index) {
        if(index<=0)
            return 0;
        int[] res = new int[index];
        res[0] = 1;
        int pos0 = 0;
        int pos1 = 0;
        int pos2 = 0;
        for(int i=1;i<index;++i){
            res[i]=Math.min(Math.min(res[pos0]*2,res[pos1]*3),res[pos2]*5);
            if(res[i]==res[pos0]*2)
                pos0++;
            if(res[i]==res[pos1]*3)
                pos1++;
            if(res[i]==res[pos2]*5)
                pos2++;
        }
        return res[index-1];
    }
}
