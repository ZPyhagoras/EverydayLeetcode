import Datastructure.BinaryTree;

public class Main {
    public static void main(String[] args) {
        Leetcode491 Solution = new Leetcode491();
        Solution.findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
    }
    /*
    private static void test124() {
        int iMin = Integer.MIN_VALUE;
        int[] vals = {-10, 9, 20, iMin, 999};
        BinaryTree newTree = new BinaryTree(vals);
        newTree.prettyPrintTree();
        
        TreeNode TreeRoot = newTree.root;
        Leetcode124 Solution = new Leetcode124();
        System.out.println(Solution.maxPathSum(TreeRoot));
    }
    */
}