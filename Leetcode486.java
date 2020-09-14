public class Leetcode486 {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }
        for (int i = n - 2; i >= 1; i--) {
            for (int j = i + 1; j <= n -1; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[0] >= 0;
    }
}