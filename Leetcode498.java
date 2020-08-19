public class Leetcode498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length, size = m * n;
        int x, y, dx, dy;
        int[] ans = new int[size];
        int pos = 0;
        for (int i = 0; i < m + n; i++) {
            if (i % 2 == 0) {
                x = Math.min(i, m - 1); dx = -1; 
                y = Math.max(0, i - x); dy = 1;
            }
            else {
                y = Math.min(i, n - 1); dy = -1;
                x = Math.max(0, i - y); dx = 1; 
            }
            while (x >= 0 && x <= m - 1 && y >= 0 && y <= n - 1) {
                ans[pos++] = matrix[x][y];
                x += dx; y += dy;
            }
        }
        return ans;
    }
}