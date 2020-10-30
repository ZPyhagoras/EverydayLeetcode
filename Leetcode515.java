import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Datastructure.TreeNode;

public class Leetcode515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        nodeQueue.offer(root);
        int n, maxVal;
        while (!nodeQueue.isEmpty()) {
            n = nodeQueue.size();
            maxVal= Integer.MIN_VALUE;
            while (n-- > 0) {
                TreeNode cur = nodeQueue.poll();
                maxVal = Math.max(cur.val, maxVal);
                if (cur.left != null) {
                    nodeQueue.offer(cur.left);
                }
                if (cur.right != null) {
                    nodeQueue.offer(cur.right);
                }
            }
            ans.add(maxVal);
        }
        return ans;
    }
}
