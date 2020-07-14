import Datastructure.TreeNode;

public class Interview0405 {
    public boolean isValidBST(TreeNode root) {
        return recursionBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean recursionBST(TreeNode root, long max, long min) {
        return root == null || (root.val < max && root.val > min && recursionBST(root.left, root.val, min) && recursionBST(root.right, max, root.val));
    }
}