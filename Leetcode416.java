public class Leetcode416 {
    public boolean canPartition(int[] nums) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        int sum = 0, maxNum = Integer.MIN_VALUE;
        for (int n : nums) {
            sum += n;
            maxNum = Math.max(maxNum, n);
        }
        if ((sum & 1) == 1 || maxNum > sum / 2) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < m; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}
