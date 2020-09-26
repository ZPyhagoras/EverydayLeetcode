import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int cnt = 0, n = nums.length;
        while (cnt < (1 << n)) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((cnt & (1 << i)) != 0) {
                    tmp.add(nums[i]);
                }
            }
            ans.add(tmp);
            cnt++;
        }
        return ans;
    }
}
