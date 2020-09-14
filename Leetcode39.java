import java.util.LinkedList;
import java.util.List;

public class Leetcode39 {
    private List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new LinkedList<>();
        dfs(candidates, 0, new LinkedList<>(), target);
        return ans;
    }

    private void dfs(int[] candidates, int start, List<Integer> temp, int target) {
        if (target < 0) {
            return ;
        }
        else if (target == 0) {
            ans.add(new LinkedList<>(temp));
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                dfs(candidates, i, temp, target - candidates[i]);
                int l = temp.size();
                temp.remove(l - 1);
            }
        }
    }
}
