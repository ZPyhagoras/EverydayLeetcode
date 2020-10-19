import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1002 {
    public List<String> commonChars(String[] A) {
        int[] count = new int[26];
        int[] tmp = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String word : A) {
            Arrays.fill(tmp, 0);
            for (char ch : word.toCharArray()) {
                tmp[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(tmp[i], count[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i]; j++) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
