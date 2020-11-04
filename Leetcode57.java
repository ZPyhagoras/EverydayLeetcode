import java.util.LinkedList;
import java.util.List;

public class Leetcode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        List<int[]> ansList = new LinkedList<>();
        boolean flag = false;
        for (int[] inv : intervals) {
            if (inv[1] < left) {
                ansList.add(inv);
            } 
            else if (inv[0] > right) {
                if (!flag) {
                    ansList.add(new int[]{left, right});
                    flag = true;                    
                }
                ansList.add(inv);
            } 
            else {
                left = Math.min(left, inv[0]);
                right = Math.max(right, inv[1]);
            }
        }
        if (!flag) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
