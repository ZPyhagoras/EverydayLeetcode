public class Leetcode1267 {
    public int countServers(int[][] grid) {
        int n = grid.length, m = grid[0].length, connected = 0;
        int[][] pos = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean flag = false;
                for (int k = 0; k < 4 && !flag; k++) {
                    int x = i + pos[k][0], y = j + pos[k][1];
                    if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
                        flag = true;
                    }
                }
                connected = flag && grid[i][j] == 1 ? connected + 1 : connected;
            }
        }
        return connected;
    }
}