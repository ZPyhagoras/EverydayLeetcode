public class Leetcode378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] pos = new int[n];
        int ans = Integer.MAX_VALUE, row = -1;
        for (int i = 0; i < k; i++) {
            ans = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (pos[j] < n && matrix[j][pos[j]] < ans) {
                    ans = matrix[j][pos[j]];
                    row = j;
                }
            }
            pos[row]++;
        }
        return ans;
    }
}