import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int count = (1 + n) * n / 2;
        for (int i = 0; i < n; ++i) {
            num[i] = sc.nextInt();
        }
        int index = 0;
        int temp = 0;
        while (index < n) {
            long sum = 0;
            for (int i = index; i < n; ++i) {
                sum += num[i];
                if (sum == 0) {
                    count -= (n - i) * (index - temp + 1);
                    temp = index + 1;
                    break;
                }
            }
            ++index;
        }
        System.out.println(count);
    }


}
