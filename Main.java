public class Main {
    public static void main(String[] args) {
        Leetcode40 Solution = new Leetcode40();
        Solution.combinationSum2(new int[]{1,5,2,4,3}, 0);
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