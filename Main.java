public class Main {
    public static void main(String[] args) {
        Leetcode378 Solution = new Leetcode378();
        int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        int ans = Solution.kthSmallest(matrix, 8);
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