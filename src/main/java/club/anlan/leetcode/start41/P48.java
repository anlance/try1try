package club.anlan.leetcode.start41;


public class P48 {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };


        P48 p = new P48();
        p.rotate(matrix);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    // 将二维数组(正方)右转 90 度
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1)
            return;
        int len = matrix.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            // 交换一圈 (swap one circle)
            for (int i = 0; i < r - l; ++i) {
                // 一次交换 4个位置 (swap 4 positions)
                int temp = matrix[l][l + i];
                matrix[l][l + i] = matrix[r - i][l];
                matrix[r - i][l] = matrix[r][r - i];
                matrix[r][r - i] = matrix[l + i][r];
                matrix[l + i][r] = temp;
            }
            ++l;
            --r;
        }
    }
}
