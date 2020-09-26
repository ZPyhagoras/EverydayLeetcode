import java.util.ArrayList;
import java.util.List;

import Datastructure.TreeNode;

public class Leetcode113 {
    private List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        dfs(root, new ArrayList<>(), sum);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> tmp, int sum) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ans.add(tmp);
        }
        dfs(root.left, tmp, sum - root.val);
        dfs(root.right, tmp, sum - root.val);
        tmp.remove(tmp.size() - 1);
    }
}
