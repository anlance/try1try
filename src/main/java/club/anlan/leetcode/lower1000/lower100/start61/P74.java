package club.anlan.leetcode.lower1000.lower100.start61;

public class P74 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 41}
        };
        P74 p = new P74();
        System.out.println(p.searchMatrix(matrix, 80));
    }

    // 二维有序数组中找 target
    public boolean searchMatrix(int[][] matrix, int target) {
        // 从左下开始找，比他大就往右，比他小就往左
        if (matrix.length <= 0)
            return false;
        if (matrix[0].length <= 0)
            return false;
        int x = matrix.length - 1;
        int y = 0;
        while (y < matrix[0].length && x >= 0) {
            if (matrix[x][y] == target)
                return true;
            else if (matrix[x][y] > target)
                --x;
            else
                ++y;
        }
        return false;
    }
}
