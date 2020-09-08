import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 1; i <= k; ++i) {
            tmp.add(i);
        }
        tmp.add(n + 1);
        int j = 0;
        while (j < k) {
            ans.add(new ArrayList<Integer>(tmp.subList(0, k)));
            j = 0;
            while (j < k && tmp.get(j) + 1 == tmp.get(j + 1)) {
                tmp.set(j, j + 1);
                ++j;
            }
            tmp.set(j, tmp.get(j) + 1);
        }
        return ans;
    }
}
