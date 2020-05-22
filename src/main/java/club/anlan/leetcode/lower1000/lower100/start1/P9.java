package club.anlan.leetcode.lower1000.lower100.start1;

public class P9 {
    public static void main(String[] args) {
        int x = 1321;
        P9 p = new P9();
        System.out.println(p.isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        String temp = String.valueOf(x);
        int i = 0, j = temp.length() - 1;
        while (i <= j) {
            if (temp.charAt(i) == temp.charAt(j)) {
                ++i;
                --j;
            } else {
                break;
            }
        }
        return i >= j;
    }
}
