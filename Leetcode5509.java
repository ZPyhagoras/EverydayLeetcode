public class Leetcode5509 {
    public int minCost(String s, int[] cost) {
        char[] S = s.toCharArray();
        int n = S.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char flag = S[i];
            if (i + 1 < n && S[i + 1] == flag) {
                int sum = cost[i];
                int maxCost = cost[i];
                while (i + 1 < n && S[i + 1] == flag) {
                    maxCost = Math.max(maxCost, cost[i + 1]);
                    sum += cost[i + 1];
                    i++;
                }
                ans += (sum - maxCost);
            }
        }
        return ans;
    }
}
