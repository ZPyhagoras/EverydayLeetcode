public class Leetcode312 {
    public int maxCoins(int[] nums) {
        int l = nums.length;
        int[] val = new int[l + 2];
        int[][] dp = new int[l + 2][l + 2];
        for (int i = 1; i < l; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[l + 1] = 1;
        for (int i = l - 1; i >= 0; i--) {
            for (int j = i + 2; j <= l + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], val[i] * val[k] * val[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][1 + 1];
    }
}