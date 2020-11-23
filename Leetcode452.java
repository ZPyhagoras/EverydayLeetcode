import java.util.Arrays;
import java.util.Comparator;

public class Leetcode452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> o1[1] > o2[1] ? 1 : -1);
        int ans = 0, arrow = points[0][1];
        for (int[] point : points) {
            if (point[0] > arrow) {
                arrow = point[1];
                ans++;
            }
        }
        return ans;
    }
}
