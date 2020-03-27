import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            --t;
            int n = sc.nextInt();
            String str = sc.next();
            char[] a = new char[n];
            Arrays.fill(a, '0');
            a[0] = '1';
            char[] b = new char[n];
            Arrays.fill(b, '0');
            b[0] = '1';
            boolean isSame = true;
            int index = n;
            for (int i = 1; i < n; ++i) {
                if (str.charAt(i) == '0')
                    continue;
                if (str.charAt(i) == '2') {
                    a[i] = '1';
                    b[i] = '1';
                } else {
                    a[i] = '1';
                    index = i;
                    break;
                }
            }
            for (int i = index + 1; i < n; ++i) {
                b[i] = str.charAt(i);
            }
            StringBuilder aa = new StringBuilder();
            StringBuilder bb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                aa.append(a[i]);
                bb.append(b[i]);
            }
            System.out.println(aa);
            System.out.println(bb);
        }
    }
}
