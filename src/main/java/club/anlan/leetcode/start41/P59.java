package club.anlan.leetcode.start41;

public class P59 {
    public static void main(String[] args) {
        P59 p = new P59();
        int[][] res = p.generateMatrix(2);
        for (int[] r : res) {
            for (int i : r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // 1-n*n 的矩阵
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] step = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] stepT = {1, 0, 0, 0};
        int[] stepR = {0, -1, 0, 0};
        int[] stepB = {0, 0, -1, 0};
        int[] stepL = {0, 0, 0, 1};
        int x = 0;
        int y = 0;
        int index = 2;
        int pos = 0;
        int t = 0, r = n - 1, b = n - 1, l = 0;
        matrix[x][y] = 1;
        while (index <= n * n) {
            int curX = x + step[pos][0];
            int curY = y + step[pos][1];
            if (t <= curX && curX <= b && l <= curY && curY <= r) {
                matrix[curX][curY] = index;
                x = curX;
                y = curY;
                ++index;
            } else {
                l += stepL[pos];
                r += stepR[pos];
                b += stepB[pos];
                t += stepT[pos];
                pos += 1;
                pos %= 4;
            }
        }
        return matrix;
    }
}
