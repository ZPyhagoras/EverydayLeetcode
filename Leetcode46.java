import java.util.*;

public class Leetcode46 {
    private List<List<Integer>> ans;
    private List<Integer> tmp;

    private void backtrack(int first, int n) {
        if (first == n) {
            ans.add(new LinkedList<Integer>(tmp));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(tmp, first, i);
            backtrack(first + 1, n);
            Collections.swap(tmp, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ans = new LinkedList<>();
        tmp = new LinkedList<>();
        for (int num : nums) {
            tmp.add(num);
        }
        backtrack(0, nums.length);
        return ans;
    }
}