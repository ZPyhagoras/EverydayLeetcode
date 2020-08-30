package Week204;

public class Q1 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            boolean f = true;
            for (int t = 0; t < m && f; t++) {
                for (int j = 0; j < k && f; j++) {
                    int nxt = i + j * m + t;
                    if (nxt >= len || arr[i + t] != arr[nxt]) {
                        f = false;
                    }
                }
            }
            if (f) {
                return true;
            }
        }
        return false;
    }
}