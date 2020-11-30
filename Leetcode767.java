public class Leetcode767 {
    public String reorganizeString(String S) {
        char[] charAts = S.toCharArray();
        int len = charAts.length;
        if (charAts.length < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        for (char c : charAts) {
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (len + 1) / 2) {
            return "";
        }
        char[] reorganizeArray = new char[len];
        int even = 0, odd = 1;
        int hLen = len / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (counts[i] > 0 && counts[i] <= hLen && odd < len) {
                reorganizeArray[odd] = c;
                counts[i]--;
                odd += 2;
            }
            while (counts[i] > 0) {
                reorganizeArray[even] = c;
                counts[i]--;
                even += 2;
            }
        }
        return new String(reorganizeArray);
    }
}
