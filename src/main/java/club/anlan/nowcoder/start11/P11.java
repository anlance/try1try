package club.anlan.nowcoder.start11;


public class P11 {
    public static void main(String[] args) {
        P11 p = new P11();
        System.out.println(p.NumberOf1(8));
    }

    // 二进制中1的个数
    public int NumberOf1(int n) {
        String str = Integer.toUnsignedString(n,2);
        int res = 0;
        for(int i=0;i<str.length();++i){
            if('1'==str.charAt(i))
                ++res;
        }
        return res;
    }
}
