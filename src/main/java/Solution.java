import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            --t;
            int n = sc.nextInt();
            int[] number = new int[n];
            int[] res = new int[n];
            Arrays.fill(res,0);
            boolean[] used = new boolean[n];
            for (int i = 0; i < n; ++i) {
                number[i] = sc.nextInt();
            }
            List<Integer> list = new LinkedList<>();
            int index = 1;
            res[0]=1;
            list.add(0);
            int closed = n*n;

            for(int i=0;i<res.length;++i){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }

    public static int gcd(int a, int b) {
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
