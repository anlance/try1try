package club.anlan.leetcode.start61;

public class P67 {
    public static void main(String[] args) {
        P67 p = new P67();
        String a = "100";
        String b = "110010";
        System.out.println(p.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        if (a.length() <= 0)
            return b;
        if (b.length() <= 0)
            return a;
        int max = 0;
        int min = 0;
        String maxStr = "";
        String minStr = "";
        if (a.length() > b.length()) {
            max = a.length();
            min = b.length();
            maxStr = a;
            minStr = b;
        } else {
            min = a.length();
            max = b.length();
            minStr = a;
            maxStr = b;
        }
        char[] c = new char[max + 1];
        boolean isAdd = false;
        for (int i = min - 1, j = max - 1; i >= 0; --i, --j) {
            if (minStr.charAt(i) == '0' && maxStr.charAt(j) == '0') {
                if (isAdd) {
                    c[j + 1] = '1';
                    isAdd = false;
                } else
                    c[j + 1] = '0';
            } else if (minStr.charAt(i) == '1' && maxStr.charAt(j) == '1') {
                if (isAdd)
                    c[j + 1] = '1';
                else
                    c[j + 1] = '0';
                isAdd = true;
            } else {
                if (isAdd) {
                    c[j + 1] = '0';
                } else
                    c[j + 1] = '1';
            }
        }
        if (max == min) {
            if(isAdd){
                c[0] = '1';
                return String.valueOf(c);
            }
            return String.valueOf(c,1,c.length-1);
        }
        if (isAdd) {
            int index = -1;
            for (int i = max - min-1; i >= 0; --i) {
                if (maxStr.charAt(i) == '0') {
                    c[i + 1] = '1';
                    index = i;
                    break;
                } else {
                    c[i + 1] = '0';
                }
            }
            if (index == -1) {
                c[0] = '1';
                return String.valueOf(c);
            } else {
                for (int i = index-1; i >= 0; --i) {
                    c[i + 1] = maxStr.charAt(i);
                }
                return String.valueOf(c, 1, c.length - 1);
            }
        } else {
            for (int i = max - min-1; i >= 0; --i) {
                c[i + 1] = maxStr.charAt(i);
            }
            return String.valueOf(c, 1, c.length - 1);
        }
    }
}
