import java.util.Arrays;

public class Leetcode5513 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] edges = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edges[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        boolean[] flag = new boolean[n];
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++) {
                if(!flag[j] && (t == -1 || dis[t] > dis[j])){
                    t = j;
                }
            }
            if(i >= 1) {
                ans += dis[t];
            }
            flag[t] = true;
            for(int j = 0; j < n; j++) {
                if(!flag[j]) {
                    dis[j] = Math.min(dis[j], edges[t][j]);
                }
            }
        }
        return ans;
    }
}
