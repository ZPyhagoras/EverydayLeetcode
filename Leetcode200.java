public class Leetcode200 {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i], ty = y + dy[i];
            if (tx >= 0 && tx < m && ty >= 0 && ty < n && grid[tx][ty] == '1') {
                dfs(grid, tx, ty);
            }
        }
    }
}
