public class Leetcode5507 {
    public String modifyString(String s) {
        char[] S = s.toCharArray();
        int n = S.length;
        char pre, now, nxt;
        for (int i = 0; i < n; i++) {
            now = S[i];
            if (now == '?') {
                pre = (i - 1 >= 0 ? S[i - 1] : '#');
                nxt = (i + 1 <= n - 1 ? S[i + 1] : '#');
                char alpha = 'a';
                while ((pre == alpha || nxt == alpha) && alpha <= 'z') {
                    alpha++;
                }
                S[i] = alpha;
            }
        }

        return new String(S);
    }
}
