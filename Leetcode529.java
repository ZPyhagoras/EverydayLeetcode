import java.util.LinkedList;
import java.util.Queue;

public class Leetcode529 {
    private int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
    private int[] dy = {1, 0, -1, 0, -1, 1, 1, -1};
    int m, n;
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        m = board.length; n = board[0].length;
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        }
        else {
            // BFS
            bfs(board, x, y);
        }
        return board;
    }

    void dfs(char[][] board, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; ++i) {
            int tx = x + dx[i], ty = y + dy[i];
            if (tx >= 0 && tx < m && ty >= 0 && ty < n && board[tx][ty] == 'M') {
                cnt++;
            }
        }
        if (cnt == 0) {
            board[x][y] = 'B';
            for (int i = 0; i < 8; ++i) {
                int tx = x + dx[i], ty = y + dy[i];
                if (tx >= 0 && tx < m && ty >= 0 && ty < n && board[tx][ty] == 'E') {
                    dfs(board, tx, ty);
                }
            }
        } 
        else {
            board[x][y] = (char) (cnt + '0');
        }
    }

    void bfs(char[][] board, int x, int y) {
        boolean[][] visit = new boolean[m][n];
        Queue<Integer[]> nodeQueue = new LinkedList<>();
        nodeQueue.offer(new Integer[]{x, y});
        visit[x][y] = true;
        while (!nodeQueue.isEmpty()) {
            Integer[] pos = nodeQueue.poll();
            int nx = pos[0], ny = pos[1], cnt = 0;
            for (int i = 0; i < 8; i++) {
                int tx = nx + dx[i], ty = ny + dy[i];
                if (tx >= 0 && tx < m && ty >= 0 && ty < n && board[tx][ty] == 'M') {
                    cnt++;
                }
            }
            if (cnt == 0) {
                board[nx][ny] = 'B';
                for (int i = 0; i < 8; i++) {
                    int tx = nx + dx[i], ty = ny + dy[i];
                    if (tx >= 0 && tx < m && ty >= 0 && ty < n && !visit[tx][ty] && board[tx][ty] == 'E') {
                        nodeQueue.offer(new Integer[]{tx, ty});
                        visit[tx][ty] = true;
                    }
                }
            }
            else {
                board[nx][ny] = (char)(cnt + '0');
            }
        }
    }
}