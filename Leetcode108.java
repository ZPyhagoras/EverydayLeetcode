public class Leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return genarateBST(nums, 0, nums.length - 1);
    }

    private TreeNode genarateBST(int[] nums, int st, int ed) {
        if (st > ed) {
            return null;
        }
        int mid = (st + ed) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = genarateBST(nums, st, mid - 1);
        root.right = genarateBST(nums, mid + 1, ed);
        return root;
    }
}