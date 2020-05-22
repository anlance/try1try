package club.anlan.leetcode.lower1000.lower100.start61;

public class P73 {
    public static void main(String[] args) {
        P73 p = new P73();
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        p.setZeroes(matrix);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix.length <= 0)
            return;
        boolean[] usedX = new boolean[matrix.length];
        if (matrix[0].length <= 0)
            return;
        boolean[] usedY = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    usedX[i] = true;
                    usedY[j] = true;
                }
            }
        }
        for (int i = 0; i < usedX.length; ++i) {
            if (usedX[i]) {
                for (int k = 0; k < matrix[0].length; ++k) {
                    matrix[i][k] = 0;
                }
            }
        }
        for (int j = 0; j < usedY.length; ++j) {
            if (usedY[j]) {
                for (int k = 0; k < matrix.length; ++k) {
                    matrix[k][j] = 0;
                }
            }
        }
    }
}
