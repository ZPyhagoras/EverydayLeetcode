public class Leetcode1370 {
    public String sortString(String s) {
        char[] chs = s.toCharArray();
        int[] cnt = new int[26];
        int l = chs.length;
        for (char ch : chs) {
            cnt[ch - 'a']++;
        }
        StringBuffer ans = new StringBuffer();
        while (ans.length() < l) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    ans.append((char)(i + 'a'));
                    cnt[i]--;
                }
            }
            for (int i = 26 - 1; i >= 0; i++) {
                if (cnt[i] > 0) {
                    ans.append((char)(i + 'a'));
                    cnt[i]--;
                }
            }
        }
        return ans.toString();
    }
}
