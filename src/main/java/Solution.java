import java.io.BufferedInputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            --t;
            long n = sc.nextLong();
            long m = n;
            int number = -1;
            while (m>0){
                number+=(m&1);
                m>>=1;
            }
            long sn = (n&(-n))<<number;
            System.out.println((n+1)*sn/2);
        }
    }

}
