public class Leetcode329 {
    private int row, col;
    private int[][] mem, numMap;
    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        else {
            row = matrix.length;  col = matrix[0].length;
            numMap = matrix;
            mem = new int[row][col];
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    private int dfs(int px, int py) {
        if (mem[px][py] != 0) {
            return mem[px][py];
        }
        mem[px][py]++;
        for (int[] dir : dirs) {
            int tx = px + dir[0], ty = py + dir[1];
            if (tx >= 0 && tx < row && ty >= 0 && ty < col && numMap[tx][ty] > numMap[px][py]) {
                mem[px][py] = Math.max(mem[px][py], dfs(tx, ty) + 1);
            }
        }
        return mem[px][py];
    }
}