import java.util.LinkedList;
import java.util.List;

public class Leetcode37 {
    private boolean[][] row;
    private boolean[][] col;
    private boolean[][][] block;
    private boolean flag;
    private List<int[]> points;

    public void solveSudoku(char[][] board) {
        row = new boolean[9][9];
        col = new boolean[9][9];
        block = new boolean[3][3][9];
        flag = false;
        points = new LinkedList<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    points.add(new int[]{i, j});
                } 
                else {
                    int num = board[i][j] - '0' - 1;
                    row[i][num] = col[j][num] = block[i / 3][j / 3][num] = true;
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int idx) {
        if (points.size() == idx) {
            flag = true;
            return;
        }

        int[] space = points.get(idx);
        int i = space[0], j = space[1];
        for (int num = 0; num < 9 && !flag; num++) {
            if (!row[i][num] && !col[j][num] && !block[i / 3][j / 3][num]) {
                row[i][num] = col[j][num] = block[i / 3][j / 3][num] = true;
                board[i][j] = (char) (num + '0' + 1);
                dfs(board, idx + 1);
                row[i][num] = col[j][num] = block[i / 3][j / 3][num] = false;
            }
        }
    }
}
