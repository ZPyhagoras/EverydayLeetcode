import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode40 {
    private List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new LinkedList<>());
        return ans;
    }

    private void dfs(int[] candidates, int start, int target, List<Integer> tmp) {
        if (target == 0) {
            ans.add(new LinkedList<>(tmp));
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                if (target - candidates[i] < 0) {
                    break;
                }
                else if (i == start || candidates[i] != candidates[i - 1]) {
                    tmp.add(candidates[i]);
                    dfs(candidates, i + 1, target - candidates[i], tmp);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}
