public class Main {
    public static void main(String[] args) {
        // Leetcode124 Solution124 = new Leetcode124();
        int iMin = Integer.MIN_VALUE;
        int[] vals = {-10, 9, 20, iMin, 999};
        BinaryTree newTree = new BinaryTree(vals);
        newTree.prettyPrintTree();
        /*
        TreeNode TreeRoot = newTree.root;
        Leetcode124 Solution = new Leetcode124();
        System.out.println(Solution.maxPathSum(TreeRoot));
        */
    }
}