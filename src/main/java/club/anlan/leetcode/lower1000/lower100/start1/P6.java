package club.anlan.leetcode.lower1000.lower100.start1;

public class P6 {
    public static void main(String[] args) {
        P6 p = new P6();
        String s = "PAYPALISHIRING";
        System.out.println(p.convert(s,3));
    }


    // 对于 numRows 对应的规律
    // 2 3 4 5
    // ↓ ↓ ↓ ↓
    // 2 4 6 8 (即 y = (x-1)*2 ) 这是最外面字符（顶层和底层）的偏移的步子
    // 然后中间会波浪形的递减（且每一层只可能出现两种加法，这两种加法加起来是 numRows-1 的二倍）
    // 举个例子：
    // +8 +8 +8 +8
    // +6 +2 +6 +2  （ 6+2 = (5-1)*2 ）
    // +4 +4 +4 +4  （ 4+4 = (5-1)*2 ）
    // +2 +6 +2 +6
    // +8 +8 +8 +8
    // 还有一个很关键的问题，就是字符串的长度，需要知道每层加到什么时候就不再加了，
    // 其实只需要加的长度大于总长度就应该停止了
    public String convert(String s, int numRows) {
        if (s.length() == 0 || s.length() == 1 || s.length() == 2 || numRows <= 1)
            return s;
        String res = "";

        int edge = (numRows - 1) * 2;
        int index = 0;
        for (int i = 0; i < numRows; ++i) {// 对每一层进行字符串拼接操作
            // 每次循环将两次不同操作组合到一起
            index = i;
            if(i==0||i==numRows-1)
                edge = (numRows - 1) * 2;
            else
                edge-=2;
            int nEdge = (numRows-1) * 2 - edge;
            while (index < s.length()) {
                res += s.charAt(index);
                index += edge;
                if(nEdge!=0){// 排除顶层和底层的重复操作
                    if (index >= s.length())
                        break;
                    res += s.charAt(index);
                    index += nEdge;
                }
            }
        }
        return res;
    }
}
