public class Leetcode76 {
    public String minWindow(String s, String t) {
        int[] tMap = new int[128];
        char[] S = s.toCharArray(), T = t.toCharArray();
        for (char c : T) {
            tMap[c]++;
        }
        int left = 0, right = 0, cnt = 0, maxlen = S.length + 1, start = left;
        while (right < S.length) {
            if ((--tMap[S[right]]) >= 0) {
                cnt++;
            }
            while(cnt == T.length) {
                if (maxlen > right - left + 1) {
                    maxlen = right - left + 1;
                    start = left;
                } 
                if ((++tMap[S[left]]) > 0) {
                    cnt--;
                }
                left++;
            }
            right++;
        }
        return maxlen == S.length + 1 ? "" : s.substring(start, start + maxlen);
    }
}
