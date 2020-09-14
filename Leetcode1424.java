import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> transform = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                List<Integer> numList = transform.getOrDefault(i + j, new ArrayList<>());
                numList.add(nums.get(i).get(j));
                transform.put(i + j, numList);
                cnt++;
            }
        }
        int[] ans = new int[cnt];
        int pos = 0;
        for (int i = 0; i < transform.size(); i++) {
            List<Integer> numList = transform.get(i);
            for (int j = numList.size() - 1; j >= 0; j--) {
                ans[pos++] = numList.get(j);
            }
        }
        return ans;
    }
}