public class Main {
    public static void main(String[] args) {
        Leetcode402 Solution = new Leetcode402();
        String ans = Solution.removeKdigits("1432219", 3);
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