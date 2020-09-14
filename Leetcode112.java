import java.util.LinkedList;
import java.util.Queue;

import Datastructure.TreeNode;

public class Leetcode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        else if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        nodeQueue.offer(root);  valQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode tmpNode = nodeQueue.poll();
            int tmpVal = valQueue.poll();
            if (tmpNode.left == null && tmpNode.right == null) {
                if (tmpVal == sum) {
                    return true;
                }
            }
            else {
                if (tmpNode.left != null) {
                    nodeQueue.offer(tmpNode.left);
                    valQueue.offer(tmpNode.left.val + tmpVal);
                }
                if (tmpNode.right != null) {
                    nodeQueue.offer(tmpNode.right);
                    valQueue.offer(tmpNode.right.val + tmpVal);
                }
            }
        }
        return false;
    }
}