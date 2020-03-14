package club.anlan.leetcode.start21;

import java.util.HashSet;
import java.util.Set;

public class P37 {
    public static void main(String[] args) {
        P37 p = new P37();
        char[][] bord = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        p.solveSudoku(bord);
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                System.out.print(bord[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 解决数独问题
    public void solveSudoku(char[][] board) {
        boolean[] isSuccess = {false};
        boolean[][] row = new boolean[9][9]; // 表示 x 行 v 值 是否已经被使用
        boolean[][] col = new boolean[9][9];// 表示 y 列 v 值 是否已经被使用
        boolean[][] cube = new boolean[9][9];// 表示 第x 个 3x3 矩阵中 v 值 是否已经被使用
        // 初始化三个判断数组
        for(int i=0;i<9;++i){
            for(int j=0;j<9;++j){
                if(board[i][j]!='.'){
                    row[i][board[i][j] - 49] = true;
                    col[j][board[i][j] - 49] = true;
                    cube[i / 3 * 3 + j / 3][board[i][j] - 49] = true;
                }
            }
        }
        dfs(board, 0, 0, isSuccess, row, col, cube);
    }

    public void dfs(char[][] board, int x, int y, boolean[] isSuccess, boolean[][] row, boolean[][] col, boolean[][] cube) {

        if (isSuccess[0]) // 找到一个满足的即返回
            return;
        if (board[x][y] != '.') { // 当前位置已有数字
            if (x == 8 && y == 8) { // 完成填充
                isSuccess[0] = true;
            } else if (y == 8)
                dfs(board, x + 1, 0, isSuccess, row, col, cube); // 下移一个
            else
                dfs(board, x, y + 1, isSuccess, row, col, cube); // 向右填充
        } else {
            for (int i = 1; i < 10; ++i) {
                board[x][y] = (char) (48 + i); // 填充

                if (isValid2(board, x, y, row, col, cube)) { // 如果满足，则向下
                    row[x][board[x][y] - 49] = true;
                    col[y][board[x][y] - 49] = true;
                    cube[x / 3 * 3 + y / 3][board[x][y] - 49] = true;

                    if (x == 8 && y == 8) { // 完成填充
                        isSuccess[0] = true;
                        return;
                    } else if (y == 8)
                        dfs(board, x + 1, 0, isSuccess, row, col, cube);
                    else
                        dfs(board, x, y + 1, isSuccess, row, col, cube);
                    // 填充该值失败
                    row[x][board[x][y] - 49] = false;
                    col[y][board[x][y] - 49] = false;
                    cube[x / 3 * 3 + y / 3][board[x][y] - 49] = false;
                }
                if (isSuccess[0]) { // 不再继续取值
                    return;
                }
            }
            // 当前位置填充失败
            board[x][y] = '.';
        }
    }

    public boolean isValid2(char[][] board, int x, int y, boolean[][] row, boolean[][] col, boolean[][] cube) {
        if (row[x][board[x][y] - 49])
            return false;
        if (col[y][board[x][y] - 49])
            return false;
        // 判断小矩阵中是否满足
        // 00 01 02
        // 30 31 32
        // 60 61 62
        // 共 9 个小矩阵
        return !cube[x / 3 * 3 + y / 3][board[x][y] - 49];
    }

    // 下面的判断规则过于耗费时间 (很明显进行了多余的判断操作)
    public boolean isValid(char[][] board, int x, int y) {
        // 检查 行
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            if (board[x][i] != '.') {
                if (set.contains(board[x][i]))
                    return false;
                set.add(board[x][i]);
            }
        }
        // 检查 列
        set.clear();
        for (int i = 0; i < 9; ++i) {
            if (board[i][y] != '.') {
                if (set.contains(board[i][y]))
                    return false;
                set.add(board[i][y]);
            }
        }
        // 检查 3x3
        set.clear();
        x = x / 3 * 3;
        y = y / 3 * 3;
        for (int i = x; i < x + 3; ++i) {
            for (int j = y; j < y + 3; ++j) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j]))
                        return false;
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }


}
