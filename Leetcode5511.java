public class Leetcode5511 {
    public int numSpecial(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        int m = mat.length, n = mat[0].length;
        int[] col = new int[n], row = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    col[j]++;
                    row[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && (col[j] == 1 && row[i] == 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
