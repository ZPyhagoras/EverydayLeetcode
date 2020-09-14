package Datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int[] nodeVals) {
        root = new TreeNode(nodeVals[0]);
        Queue<TreeNode> qNodes = new LinkedList<>();
        qNodes.add(root);
        int i = 1;
        while (!qNodes.isEmpty()) {
            TreeNode fNode = qNodes.poll();

            int lVal = Integer.MIN_VALUE, rVal = Integer.MIN_VALUE;

            if (i < nodeVals.length) {
                lVal = nodeVals[i];  i++;
            }
            if (lVal != Integer.MIN_VALUE) {
                fNode.left = new TreeNode(lVal);
                qNodes.add(fNode.left);
            }

            if (i < nodeVals.length) {
                rVal = nodeVals[i];  i++;
            }
            if (rVal != Integer.MIN_VALUE) {
                fNode.right = new TreeNode(rVal);
                qNodes.add(fNode.right);
            }
        }
    }

    private void prettyPrintTree(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            System.out.println("Empty tree");
            return;
        }
    
        if (node.right != null) {
            prettyPrintTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.val);
    
        if (node.left != null) {
            prettyPrintTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    public void prettyPrintTree() {
        prettyPrintTree(root,  "", true);
    }
}