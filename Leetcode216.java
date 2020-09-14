import java.util.ArrayList;
import java.util.List;

public class Leetcode216 {
    private List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        dfs(k, 1, n, new ArrayList<>());
        return ans;
    }

    private void dfs(int k, int start, int n, List<Integer> tmp) {
        if (tmp.size() == k && n == 0) {
            ans.add(new ArrayList<>(tmp));
        }
        else if (tmp.size() < k && n > 0) {
            for (int i = start; i <= 9; i++) {
                tmp.add(i);
                dfs(k, i + 1, n - i, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
