public class Leetcode1402 {
    public int maxSatisfaction(int[] satisfaction) {
        int[] sortedSatisfaction = CountingSort(satisfaction, true);
        int preSum = 0, ans = 0;
        for (int sat : sortedSatisfaction) {
            if (preSum + sat > 0) {
                preSum += sat;
                ans += preSum;
            }
            else {
                break;
            }
        }
        return ans;
    }

    private int[] CountingSort(int[] nums, boolean reverse) {
        int[] counter = new int[2001];
        for (int num : nums) {
            counter[num + 1000] += 1;
        }
        int[] sortedNums = new int[nums.length];
        int pos = 0;
        if (reverse) {
            for (int i = 2000; i >= 0; i--) {
                for (int j = 0; j < counter[i]; j++) {
                    sortedNums[pos] = i - 1000;
                    pos++;
                }
            }
        }
        else {
            for (int i = 0; i <= 2000; i++) {
                for (int j = 0; j < counter[i]; j++) {
                    sortedNums[pos] = i - 1000;
                    pos++;
                }
            }
        }
        return sortedNums;
    }
}