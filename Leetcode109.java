import java.util.ArrayList;
import java.util.List;

import Datastructure.ListNode;
import Datastructure.TreeNode;

public class Leetcode109 {
    private List<Integer> Linkedlist2List(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.val);
            head = head.next;
        }
        return ans;
    }

    private TreeNode genarateBST(List<Integer> nums, int st, int ed) {
        if (st > ed) {
            return null;
        }
        int mid = (st + ed) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = genarateBST(nums, st, mid - 1);
        root.right = genarateBST(nums, mid + 1, ed);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums = Linkedlist2List(head);
        return genarateBST(nums, 0, nums.size());
    }
}