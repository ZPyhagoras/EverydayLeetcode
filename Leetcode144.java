import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import Datastructure.TreeNode;

public class Leetcode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode node = null;
        nodeStack.push(root);
        while (!nodeStack.empty()) {
            node = nodeStack.pop();
            ans.add(node.val);
            if (node.right != null) {
                nodeStack.push(node.right);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
            }
        }
        return ans;
    }
}
