import Datastructure.TreeNode;

public class Leetcode124 {
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxNode(root);
        return ans;
    }

    private int maxNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = Math.max(maxNode(root.left), 0);
        int maxRight = Math.max(maxNode(root.right), 0);

        ans = Math.max(ans, root.val + maxLeft + maxRight);

        return Math.max(maxLeft, maxRight) + root.val;
    }
}