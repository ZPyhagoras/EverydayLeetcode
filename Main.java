public class Main {
    public static void main(String[] args) {
        Leetcode5508 Solution = new Leetcode5508();
        int ans = Solution.numTriplets(new int[]{1, 1}, new int[]{1, 1, 1});
        System.out.println(ans);
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