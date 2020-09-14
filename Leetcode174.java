public class Leetcode174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[n - 1] = 1;
        for (int j = m - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                dp[i] = Math.max(Math.min(dp[i], dp[i + 1]) - dungeon[j][i], 1);
            }
        }
        return dp[0];
    }
}