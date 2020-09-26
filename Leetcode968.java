import Datastructure.TreeNode;

public class Leetcode968 {
    private int ans;
    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        dfs(root);
        return Math.max(ans, 1);
    }

    private int dfs(TreeNode root) {  //0: monitor, 1: see, 2: none
        if (root == null) {
            return 1;
        }
        int leftState = dfs(root.left), rightState = dfs(root.right);
        if (leftState == 2 || rightState == 2) {
            ans++;
            return 0;
        }
        else if (leftState == 1 && rightState == 1) {
            return 2;
        }
        else {
            return 1;
        }
    }
}
