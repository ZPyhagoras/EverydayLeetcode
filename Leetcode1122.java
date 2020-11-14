public class Leetcode1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int n : arr1) {
            cnt[n]++;
        }
        int pos = 0;
        int[] ans = new int[arr1.length];
        for (int n : arr2) {
            while (cnt[n] > 0) {
                ans[pos++] = n;
                cnt[n]--;
            }
        }
        for (int n = 0; n <= 1000; n++) {
            while (cnt[n] > 0) {
                ans[pos++] = n;
                cnt[n]--;
            }
        }
        return ans;
    }
}
