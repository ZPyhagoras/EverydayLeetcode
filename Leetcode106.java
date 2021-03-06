import java.util.HashMap;
import java.util.Map;

import Datastructure.TreeNode;

public class Leetcode106 {
    private int[] postOrder;
    private Map<Integer, Integer> inorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrder = postorder;
        inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return Reconstruction(0, inorder.length, 0, postOrder.length);
    }

    private TreeNode Reconstruction(int inStart, int inEnd, int postStart, int postEnd) {
        if (postStart == postEnd) {
            return null;
        }
        int curVal = postOrder[postEnd - 1];
        int curInIndex = inorderIndex.get(curVal);
        TreeNode curNode = new TreeNode(curVal);
        curNode.left = Reconstruction(inStart, curInIndex, postStart, postStart + curInIndex - inStart);
        curNode.right = Reconstruction(curInIndex + 1, inEnd, postStart + curInIndex - inStart, postEnd - 1);
        return curNode;
    }
}