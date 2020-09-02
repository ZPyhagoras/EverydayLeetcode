import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                dp[i] |= (dp[j] && wordSet.contains(s.substring(j, i)));
            }
        }
        return dp[s.length()];
    }
}