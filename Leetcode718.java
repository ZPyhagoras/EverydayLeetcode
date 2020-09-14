public class Leetcode718 {

    public int findLength(int[] A, int[] B) {
        int maxLen = 0;
        int[] dp = new int[B.length + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[j + 1] = dp[j] + 1;
                }
                else {
                    dp[j + 1] = 0;
                }
                maxLen = Math.max(maxLen, dp[j + 1]);
            }
        }
        return maxLen;
    }
}