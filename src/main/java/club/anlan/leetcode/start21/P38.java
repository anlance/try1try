package club.anlan.leetcode.start21;

public class P38 {
    public static void main(String[] args) {
        P38 p = new P38();
        System.out.println(p.countAndSay(6));
        // "312211"
    }

    // 连续的会被加到一起
    public String countAndSay(int n) {
        String res = "1";
        while (n > 1) {
            StringBuilder temp = new StringBuilder();
            int index = 0;
            while (index < res.length()) {
                int number = 0;
                for (int i = index; i < res.length(); ++i) {
                    ++number;
                    if (i + 1 >= res.length() || res.charAt(i + 1) != res.charAt(i)) {
                        temp.append(number).append(res.charAt(i));
                        index = i + 1;
                        break;
                    }
                }
            }
            res = temp.toString();
            temp.delete(0, temp.length());
            --n;
        }
        return res;
    }


}
