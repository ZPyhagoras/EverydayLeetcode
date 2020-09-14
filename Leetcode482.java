public class Leetcode482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (cnt % K == 0 && cnt != 0) {
                    ans.insert(0, '-');
                }
                ans.insert(0, (char)(ch - 32));
                cnt++;
            }
            else if ((ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                if (cnt % K == 0 && cnt != 0) {
                    ans.insert(0, '-');
                }
                ans.insert(0, ch);
                cnt++;
            }
        }
        return ans.toString();
    }

    public String licenseKeyFormatting1(String S, int K) {
        S = S.replace("-", "").toUpperCase();
        StringBuilder ans = new StringBuilder(S);
        for (int i = S.length() - K; i > 0; i -= K) {
            ans.insert(i, '-');
        }
        return ans.toString();
    }
}