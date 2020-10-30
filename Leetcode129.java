import Datastructure.TreeNode;

public class Leetcode129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
