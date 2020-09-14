import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode229 {
    public List<Integer> majorityElement1(int[] nums) {
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        for (int num : nums) {
            if (cand1 == num) {
                count1++;
            }
            else if (cand2 == num) {
                count2++;
            }
            else if (count1 == 0) {
                cand1 = num;
                count1++;
            }
            else if (count2 == 0) {
                cand2 = num;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        count1 = count2 = 0;
        for (int num : nums) {
            if (cand1 == num) {
                count1++;
            }
            else if (cand2 == num) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            res.add(cand1);
        }
        if (count2 > nums.length / 3) {
            res.add(cand2);
        }

        return res;
    }

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> numsCnt = new HashMap<>();
        Set<Integer> ans = new HashSet<>();
        int cnt = nums.length / 3;
        for (int n : nums) {
            int nCnt = numsCnt.getOrDefault(n, 0) + 1;
            if (nCnt > cnt && !ans.contains(n)) {
                ans.add(n);
            }
            numsCnt.put(n, nCnt);
        }
        return new ArrayList<>(ans);
    }
}
    