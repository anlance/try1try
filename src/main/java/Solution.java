import java.io.BufferedInputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            --t;
            char[][] map = new char[9][9];
            for (int i = 0; i < 9; i++) {
                String str = sc.next();
                for (int j = 0; j < 9; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            int[][] step = {{0, 0}, {1, 3}, {2, 6}, {3, 1}, {4, 4}, {5, 7}, {6, 2}, {7, 5}, {8, 8}};
            for (int i = 0; i < 9; i++) {
                int x = step[i][0];
                int y = step[i][1];
                char temp = map[x][y];
                if (temp > '1') {
                    temp -= 1;
                } else {
                    temp += 1;
                }
                map[x][y] = temp;
            }
            for (int i = 0; i < 9; i++) {
                String str = "";
                for (int j = 0; j < 9; j++) {
                    str += map[i][j];
                }
                System.out.println(str);

            }
        }
    }


}
