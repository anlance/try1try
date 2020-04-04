package club.anlan.leetcode.start61;

public class P79 {
    public static void main(String[] args) {
        P79 p = new P79();
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        char[][] s = {{'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}};
        char[][] t = {{'a', 'b'}};
        char[][] ff = {{'a', 'a', 'a'},
                {'a', 'b', 'b'},
                {'a', 'b', 'b'},
                {'b', 'b', 'b'},
                {'b', 'b', 'b'},
                {'a', 'a', 'a'},
                {'b', 'b', 'b'},
                {'a', 'b', 'b'},
                {'a', 'a', 'b'},
                {'a', 'b', 'a'}};
        String temp = "aabaaaabbb";

        System.out.println(p.exist(ff, temp));
        System.out.println(p.exist(board, "ABCB"));
        System.out.println("-----");
        System.out.println(p.exist(board, word));
        System.out.println(p.exist(s, "AAB"));
        System.out.println(p.exist(t, "ab"));
        System.out.println(p.exist(t, "ba"));
    }

    // 1 <= len,width <= 200
    // 1 <= word.length <= 10^3
    public boolean exist(char[][] board, String word) {
        if (word.length() > board.length * board[0].length)
            return false;
        boolean[][] used = new boolean[board.length][board[0].length];
        int[][] step = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    boolean isExist = dfs(board, word, step, used, i, j, 1);
                    if (isExist)
                        return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int[][] step, boolean[][] used, int i, int j, int index) {
//        System.out.println(index + "----" + i + ":" + j);
        if (used[i][j])
            return false;
        if (index == word.length())
            return true;
        used[i][j] = true;
        boolean res = false;
        for (int k = 0; k < 4; ++k) {
            int nextI = i + step[k][0];
            int nextJ = j + step[k][1];
            if (isValid(nextI, nextJ, board.length, board[0].length)) {
                if (board[nextI][nextJ] == word.charAt(index)) {
                    res = res || dfs(board, word, step, used, nextI, nextJ, index + 1);
                }
            }
        }
        used[i][j] = false;
        return res;
    }

    public boolean isValid(int i, int j, int height, int width) {
        if (i < 0 || i >= height)
            return false;
        if (j < 0 || j >= width)
            return false;
        return true;
    }
}
