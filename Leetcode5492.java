public class Leetcode5492 {
    private final long mod = (long)1e9 + 7;
    public int numWays(String s) {
        int cnt = 0;
        char[] nums = s.toCharArray();

        for (char ch : nums) {
            if (ch == '1') {
                cnt += 1;
            }
        }
        if (cnt == 0) {
            long n = nums.length;
            return (int)((n - 1) % mod * (n - 2) % mod / 2 % mod);
        }
        else if (cnt % 3 != 0) {
            return 0;
        }
        else {
            cnt /= 3;
            int flag = 0, i = 0;
            long left = 0, right = 0;
            while (i < nums.length && flag <= cnt) {
                flag += (nums[i] == '1' ? 1 : 0);
                i++;
            }
            while (i < nums.length && nums[i] == '0') {
                left++;
                i++;
            }
            flag = 0;
            while (i < nums.length && flag <= cnt) {
                flag += (nums[i] == '1' ? 1 : 0);
                i++;
            }
            while (i < nums.length && nums[i] == '0') {
                right++;
                i++;
            }
            return (int)((left + 1) % mod * (right + 1) % mod);
        }
    }
}
