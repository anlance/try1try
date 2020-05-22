package club.anlan.nowcoder.start11;

import java.util.ArrayList;
import java.util.List;

public class P19 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix2 = {{1, 2}, {3, 4}};
        P19 p = new P19();
        List res = p.printMatrix(matrix);
        res.forEach(i -> System.out.println(i));
    }

    // 顺时针打印矩阵
    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
    // 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    // 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length <= 0 || matrix[0].length <= 0)
            return res;
        int sum = matrix.length * matrix[0].length;
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int[][] step = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0;
        int y = 0;
        res.add(matrix[x][y]);
        sum -= 1;
        int index = 0; // 判断位置
        while (sum > 0) {
            int sx = x + step[index][0];
            int sy = y + step[index][1];
            if (sx >= t && sx <= b && sy >= l && sy <= r) {
                res.add(matrix[sx][sy]);
                x = sx;
                y = sy;
                --sum;
            } else {
                if (index == 0) {
                    t += 1;
                } else if (index == 1) {
                    r -= 1;
                } else if (index == 2) {
                    b -= 1;
                } else {
                    l += 1;
                }
                ++index;
                index %= 4;
            }
        }
        return res;
    }
}
