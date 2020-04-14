package club.anlan.leetcode.lower1000.lower100.start41;

import java.util.ArrayList;
import java.util.List;

public class P54 {
    public static void main(String[] args) {
        P54 p = new P54();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> res = p.spiralOrder(matrix);
        res.forEach(i -> System.out.print(i + " "));
    }

    // 遍历 矩阵 ( 上 -> 右 -> 下 -> 左 -> 上 ...)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[][] step = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //  上 -> 右 -> 下 -> 左
        int b = matrix.length;
        if (b == 0)
            return res;
        int r = matrix[0].length;
        if (r == 0)
            return res;
        int number = b * r;
        b -= 1;
        r -= 1;
        int l = 0;
        int t = 0;
        int x = 0;
        int y = 0; // 起点
        int index = 0; // 第一个方向
        while (number > 0) {
            if (x < t || x > b || y < l || y > r) {
                if (index == 0) { // ->向下
                    ++t;
                    y -= 1;
                    x += 1;
                } else if (index == 1) { // ->向左
                    --r;
                    x -= 1;
                    y -= 1;
                } else if (index == 2) {// ->向上
                    --b;
                    y += 1;
                    x -= 1;
                } else {// ->向右
                    ++l;
                    x += 1;
                    y += 1;
                }
                index += 1;
                index %= 4;
            } else {
                res.add(matrix[x][y]);
                --number;
                x += step[index][0];
                y += step[index][1];
            }
        }
        return res;
    }
}
