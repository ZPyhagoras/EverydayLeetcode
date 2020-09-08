import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int fst, sec, trd;
        int target = 0;
        for (fst = 0; fst < n; fst++) {
            target = -nums[fst];
            if (fst == 0 || nums[fst] != nums[fst - 1]) {
                trd = n - 1;
                for (sec = fst + 1; sec < n; sec++) {
                    if (sec == fst + 1 || nums[sec] != nums[sec - 1]) {
                        while (sec < trd && nums[sec] + nums[trd] > target) {
                            --trd;
                        }
                        if (sec == trd) {
                            break;
                        }
                        if (nums[sec] + nums[trd] == target) {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[fst]);  list.add(nums[sec]);  list.add(nums[trd]);
                            ans.add(list);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
