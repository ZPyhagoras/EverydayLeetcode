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
}
