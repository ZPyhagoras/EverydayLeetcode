public class Leetcode5493 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l + 1 < n && arr[l] <= arr[l + 1]) {
            l++;
        }
        if (l == n - 1) {
            return 0;
        }
        while (r - 1 >= 0 && arr[r - 1] <= arr[r]) {
            r--;
        }
        int ans = Math.min(r, n - l - 1);
        int start = 0, end = r;
        while (start <= l && end <= n - 1) {
            while (end <= n - 1 && arr[start] > arr[end]) {
                end++;
            }
            if (end <= n - 1) {
                ans = Math.min(ans, end - start - 1);
            }
            start++;
        }
        return ans;
    }
}
