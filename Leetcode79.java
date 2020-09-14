public class Leetcode79 {
    private int m, n;
    private final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        m = board.length; n = board[0].length;
        vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = check(board, i, j, word.toCharArray(), 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, int x, int y, char[] s, int k) {
        if (board[x][y] != s[k]) {
            return false;
        } 
        else if (k == s.length - 1) {
            return true;
        }
        vis[x][y] = true;
        boolean result = false;
        for (int[] dir : directions) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) {
                continue;
            }
            boolean flag = check(board, nx, ny, s, k + 1);
            if (flag) {
                result = true;
                break;
            }
        }
        vis[x][y] = false;
        return result;
    }
}
