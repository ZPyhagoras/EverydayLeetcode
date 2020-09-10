import Datastructure.TreeNode;

public class Leetcode236 {
    TreeNode P, Q;
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        P = p;  Q = q;
        dfs(root);
        return ans;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean leftTree = dfs(root.left);
        boolean rightTree = dfs(root.right);
        if ((leftTree && rightTree) || ((root.val == P.val || root.val == Q.val) && (leftTree || rightTree))) {
            ans = root;
        }
        return leftTree || rightTree || (root.val == P.val || root.val == Q.val);
    }
}
