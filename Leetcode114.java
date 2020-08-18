import java.util.LinkedList;
import java.util.List;

import Datastructure.TreeNode;

public class Leetcode114 {
    private List<TreeNode> nodes;
    public void flatten(TreeNode root) {
        nodes = new LinkedList<>();
        preOrderTravel(root);
        for (int i = 1; i < nodes.size(); i++) {
            TreeNode prev = nodes.get(i - 1), curr = nodes.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void preOrderTravel(TreeNode root) {
        if (root != null) {
            nodes.add(root);
            preOrderTravel(root.left);
            preOrderTravel(root.right);
        }
    }
}