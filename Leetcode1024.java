public class Leetcode1024 {
    public int videoStitching(int[][] clips, int T) {
        int[] maxEnd = new int[T];
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxEnd[clip[0]] = Math.max(maxEnd[clip[0]], clip[1]);
            }
        }
        int lst = 0, pre = 0, cnt = 0;
        for (int i = 0; i < T; i++) {
            lst = Math.max(lst, maxEnd[i]);
            if (i == lst) {
                return -1;
            }
            if (i == pre) {
                cnt++;
                pre = lst;
            }
        }
        return cnt;
    }
}