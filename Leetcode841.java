import java.util.List;

public class Leetcode841 {
    boolean[] vis;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int num = 0;
        vis = new boolean[n];
        dfs(rooms, 0, num);
        return num == n;
    }

    public void dfs(List<List<Integer>> rooms, int x, int num) {
        vis[x] = true;
        num++;
        for (int it : rooms.get(x)) {
            if (!vis[it]) {
                dfs(rooms, it, num);
            }
        }
    }
}