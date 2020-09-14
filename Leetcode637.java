import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Datastructure.TreeNode;

public class Leetcode637 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<Double> ans = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int n = nodeQueue.size();
            double sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode p = nodeQueue.poll();
                sum += p.val;
                if (p.left != null) {
                    nodeQueue.offer(p.left);
                }
                if (p.right != null) {
                    nodeQueue.offer(p.right);
                }
            }
            ans.add(sum / n);
        }
        return ans;
    }
}
