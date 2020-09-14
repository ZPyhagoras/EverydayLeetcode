public class Leetcode647 {
    public int countSubstrings(String s) {
        int cnt = 0, sLen = s.length();
        char[] sCharArray = s.toCharArray();
        for (int i = 0; i < sLen; i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r <= sLen - 1 && sCharArray[l] == sCharArray[r]) {
                l--;  r++;  cnt++;
            }
            l = i;  r = i;
            while (l >= 0 && r <= sLen - 1 && sCharArray[l] == sCharArray[r]) {
                l--;  r++;  cnt++;
            }
        }
        return cnt;
    }

    public int manacher(String s) {
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("$#");
        for (char ch : s.toCharArray()) {
            sBuffer.append(ch);
            sBuffer.append('#');
        }
        sBuffer.append('^');

        char[] sCharArray = sBuffer.toString().toCharArray();
        int sLen = sCharArray.length;

        int[] P = new int[sLen - 1];
        int ans = 0, C = 0, R = 0;

        for (int i = 1; i < sLen - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i + 1, P[i_mirror]);
            } 
            else {
                P[i] = 1;
            }
    
            while (sCharArray[i + P[i]] == sCharArray[i - P[i]]) {
                P[i]++;
            }
    
            if (i + P[i] - 1 > R) {
                C = i;
                R = i + P[i] - 1;
            }
            ans += P[i] / 2;
        }

        return ans;
    }
}
