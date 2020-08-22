import java.util.LinkedList;
import java.util.Queue;

import Datastructure.TreeNode;

public class Leetcode297 {
    
    // Encodes a tree to a single string.
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        StringBuilder treeBuilder = new StringBuilder();
        treeBuilder.append("[");
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.remove();
            if (curNode == null) {
                treeBuilder.append("null,");
            }
            else {
                treeBuilder.append(String.valueOf(curNode.val));
                treeBuilder.append(",");
                nodeQueue.offer(curNode.left);
                nodeQueue.offer(curNode.right);
            }
        }
        treeBuilder.setLength(treeBuilder.length() - 1);
        treeBuilder.append("]");
        return treeBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeVals = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> nodeQue = new LinkedList<>();
        TreeNode root = stringToNode(nodeVals[0]);

        nodeQue.offer(root);
        int i = 1;
        while (!nodeQue.isEmpty()) {
            TreeNode fNode = nodeQue.poll();

            TreeNode leftNode, rightNode;
            leftNode = rightNode = null;
            if (i < nodeVals.length) {
                leftNode = stringToNode(nodeVals[i]);  
                i++;
            }
            if (leftNode != null) {
                fNode.left = leftNode;
                nodeQue.offer(fNode.left);
            }

            if (i < nodeVals.length) {
                rightNode = stringToNode(nodeVals[i]);  
                i++;
            }
            if (rightNode != null) {
                fNode.right = rightNode;
                nodeQue.offer(fNode.right);
            }
        }
        return root;
    }

    private TreeNode stringToNode(String val) {
        if (val.equals("null")) {
            return null;
        }
        else {
            return new TreeNode(Integer.valueOf(val));
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));