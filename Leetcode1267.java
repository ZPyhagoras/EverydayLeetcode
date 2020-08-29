public class Leetcode1267 {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] cntCol = new int[n];
        int[] cntRow = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cntRow[i]++;
                    cntCol[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (cntCol[j] > 1 || cntRow[i] > 1)) {
                    res++;
                }
            }
        }
        return res;
    }
}