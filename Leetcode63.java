public class Leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] dp = new int[m];
        dp[0] = (obstacleGrid[0][0] == 0) ? 1 : 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                }
                else {
                    if (j > 0) {
                        dp[j] += dp[j - 1];
                    }
                }
            }
        }
        return dp[m - 1];
    }
}