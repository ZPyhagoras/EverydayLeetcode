public class Leetcode935 {
    private final int mod = 1000000007;
    public int knightDialer(int N) {
        int[] dp = new int[4], tmp  = new int[4], cnt = new int[4];
        dp[0] = dp[1] = dp[2] = dp[3] = 1;
        cnt[0] = 4; cnt[1] = cnt[2] = 2; cnt[3] = 1;
        for (int i = 1; i < N; i++) {
            tmp[0] = (dp[1] + dp[2]) % mod;
            tmp[1] = ((dp[0] + dp[0]) % mod + dp[3]) % mod;
            tmp[2] = (dp[0] + dp[0]) % mod;
            tmp[3] = (dp[1] + dp[1]) % mod;
            dp[0] = tmp[0]; dp[1] = tmp[1]; dp[2] = tmp[2]; dp[3] = tmp[3];
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                ans = (ans + dp[i]) % mod;
            }
        }
        return N == 1 ? ans + 1 : ans;
    }
}