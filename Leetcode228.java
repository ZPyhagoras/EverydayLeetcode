import java.util.ArrayList;
import java.util.List;

public class Leetcode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int l = nums.length;
        if (l == 0) { return ans; }
        int sNum, eNum, sIdx, eIdx;
        sIdx = eIdx = 0;
        while (sIdx < l) {
            sNum = eNum = nums[sIdx];
            while (eIdx < l && eNum == nums[eIdx]) {
                eNum++;
                eIdx++;
            }
            if (sNum == nums[eIdx - 1]) {
                ans.add(sNum + "");
            }
            else {
                ans.add(sNum + "->" + nums[eIdx - 1]);
            }
            sIdx = eIdx;
        }
        return ans;
    }
}