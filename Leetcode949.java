public class Leetcode949 {
    public String largestTimeFromDigits(int[] arr) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    int l = 6 - i - j - k;
                    int h = arr[i] * 10 + arr[j];
                    int m = arr[k] * 10 + arr[l];
                    if (h <= 23 && m <= 59) {
                        ans = Math.max(ans, h * 60 + m);
                    }
                }
            }
        }
        return ans == Integer.MIN_VALUE ? "" : String.format("%02d:%02d",  ans / 60, ans % 60);
    } 
}
