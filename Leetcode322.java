import java.util.Arrays;

public class Leetcode322 {
    private int ans;
    public int coinChange(int[] coins, int amount) {
        ans = Integer.MAX_VALUE;
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return ans == Integer.MAX_VALUE ?  -1 : ans;
    }

    private void dfs(int[] coins, int index, int amount, int cnt) {
        int curCnt = amount / coins[index];
        if (amount % coins[index] == 0) {
            ans = Math.min(ans, cnt + curCnt);
        }
        else if (index > 0 && cnt + curCnt < ans) {
            for (int i = curCnt; i >= 0; i--) {
                dfs(coins, index - 1, amount - i * coins[index], cnt + i);
            }
        }
    }
}
