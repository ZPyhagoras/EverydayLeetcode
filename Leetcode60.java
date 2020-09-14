import java.util.ArrayList;
import java.util.List;

public class Leetcode60 {
    private int[] factorial = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuffer res = new StringBuffer();
        --k;
        for (int i = n - 1; i >= 0; i--) {
            int idx = k / factorial[i];
            res.append(Integer.toString(nums.get(idx)));
            nums.remove(idx);
            k = k % factorial[i];
        }
        return res.toString();
    }
}
