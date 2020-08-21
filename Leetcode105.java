import java.util.HashMap;
import java.util.Map;

import Datastructure.TreeNode;

public class Leetcode105 {
    private int[] preOrder;
    private int[] inOrder;
    private Map<Integer, Integer> inorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;  inOrder = inorder;
        inorderIndex = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inorderIndex.put(inOrder[i], i);
        }
        return Reconstruction(0, preOrder.length, 0, inOrder.length);
    }

    private TreeNode Reconstruction(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return null;
        }
        int curVal = preOrder[preStart];
        int curInIndex = inorderIndex.get(curVal);
        TreeNode curNode = new TreeNode(curVal);
        curNode.left = Reconstruction(preStart + 1, preStart + 1 + curInIndex - inStart, inStart, curInIndex);
        curNode.right = Reconstruction(preStart + 1 + curInIndex - inStart, preEnd, curInIndex + 1, inEnd);
        return curNode;
    }
}