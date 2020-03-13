package club.anlan.leetcode.start21;

import java.util.HashSet;
import java.util.Set;

public class P36 {
    public static void main(String[] args) {
        P36 p = new P36();
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
        System.out.println(p.isValidSudoku(bord));
    }

    // 判断是否是一个数独（二维矩阵）
    // 判断标准
    //      每一列只能包含1-9的无重复的数字
    //      每一行只能包含1-9的无重复的数字
    //      每个（不是指每一个） 3x3 矩阵（1-3 4-6 7-9 这种）只能包含1-9的无重复的数字
    // [
    //  ["5","3",".",".","7",".",".",".","."],
    //  ["6",".",".","1","9","5",".",".","."],
    //  [".","9","8",".",".",".",".","6","."],
    //  ["8",".",".",".","6",".",".",".","3"],
    //  ["4",".",".","8",".","3",".",".","1"],
    //  ["7",".",".",".","2",".",".",".","6"],
    //  [".","6",".",".",".",".","2","8","."],
    //  [".",".",".","4","1","9",".",".","5"],
    //  [".",".",".",".","8",".",".","7","9"]
    //]

    // 分三个方向判断即可
    public boolean isValidSudoku(char[][] board) {
        return isValidSudokuInRow(board) && isValidSudokuInColumn(board) && isValidSudokuInBox(board);
    }

    public boolean isValidSudokuInRow(char[][] bord) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            set.clear();
            for (int j = 0; j < 9; ++j) {
                if (bord[i][j] != '.') {
                    if (set.contains(bord[i][j]))
                        return false;
                    set.add(bord[i][j]);
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuInColumn(char[][] bord) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            set.clear();
            for (int j = 0; j < 9; ++j) {
                if (bord[j][i] != '.') {
                    if (set.contains(bord[j][i]))
                        return false;
                    set.add(bord[j][i]);
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuInBox(char[][] bord) {
        Set<Character> set = new HashSet<>();
        int indexRow = 0;
        int indexCol = 0;
        while (indexRow < 9) {
            while (indexCol < 9) {
                for (int i = indexRow; i < indexRow + 3; ++i) {
                    for (int j = indexCol; j < indexCol + 3; ++j) {
                        if (bord[j][i] != '.') {
                            if (set.contains(bord[j][i]))
                                return false;
                            set.add(bord[j][i]);
                        }
                    }
                }
                indexCol += 3;
                set.clear();
            }
            indexRow += 3;
            indexCol = 0;
        }
        return true;
    }
}
//[[".",".",".",".","5",".",".","1","."],
// [".","4",".","3",".",".",".",".","."],
// [".",".",".",".",".","3",".",".","1"],
// ["8",".",".",".",".",".",".","2","."],
// [".",".","2",".","7",".",".",".","."],
// [".","1","5",".",".",".",".",".","."],
// [".",".",".",".",".","2",".",".","."],
// [".","2",".","9",".",".",".",".","."],
// [".",".","4",".",".",".",".",".","."]]

//[["7",".",".",".","4",".",".",".","."],
// [".",".",".","8","6","5",".",".","."],
// [".","1",".","2",".",".",".",".","."],
// [".",".",".",".",".","9",".",".","."],
// [".",".",".",".","5",".","5",".","."],
// [".",".",".",".",".",".",".",".","."],
// [".",".",".",".",".",".","2",".","."],
// [".",".",".",".",".",".",".",".","."],
// [".",".",".",".",".",".",".",".","."]]