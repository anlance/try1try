import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0){
            --t;
            int n = sc.nextInt();
            int lastA = 0;
            int lastB = 0;
            boolean res = true;
            while (n>0){
                --n;
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(a<lastA || b<lastB || a<b || a-lastA<b-lastB){
                    res = false;
                }
                lastA = a;
                lastB = b;
            }
            if(res)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }


}
