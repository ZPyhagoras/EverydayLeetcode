import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Leetcode491 {
    public int getHash(int base, int mod, List<Integer> temp) {
        int hashValue = 0;
        for (int x : temp) {
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        Set<Integer> ansSet = new HashSet<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> one = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0) {
                    one.add(nums[j]);
                }
            }
            int cnt = one.size();
            if (cnt >= 2) {
                int k = 1;
                for ( ; k < cnt; k++) {
                    if (one.get(k) < one.get(k - 1)) {
                        break;
                    }
                }
                if (k == cnt) {
                    int oneHashcode = getHash(263, (int) 1E9 + 7, one);
                    if (!ansSet.contains(oneHashcode)) {
                        ansSet.add(oneHashcode);
                        ans.add(one);
                        for (int nn : one) {
                            System.out.print(nn);
                            System.out.print(',');
                        }
                        System.out.println();
                    }
                }
            }
        }
        return ans;
    }
}
