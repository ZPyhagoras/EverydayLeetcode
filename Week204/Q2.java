package Week204;

public class Q2 {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] positive = new int[n];
        int[] negative = new int[n];
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (nums[i] > 0) {
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            }
            else if (nums[i] < 0) {
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;;
                negative[i] = positive[i - 1] + 1;
            }
            else {
                positive[i] = negative[i] = 0;
            }
            ans = Math.max(ans, positive[i]);
        }
        return ans;
    }
}