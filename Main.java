import Datastructure.BinaryTree;

public class Main {
    public static void main(String[] args) {
        Leetcode297 Solution = new Leetcode297();
        BinaryTree bTree = new BinaryTree(new int[]{1,2,3,Integer.MIN_VALUE,Integer.MIN_VALUE,4,5});
        System.out.println(Solution.serialize(bTree.root));
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