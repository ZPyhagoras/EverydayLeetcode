import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode17 {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> nineMap = new HashMap<>();
        nineMap.put('2', "abc");  nineMap.put('3', "def");  nineMap.put('4', "ghi");  nineMap.put('5', "jkl");
        nineMap.put('6', "mno");  nineMap.put('7', "pqrs");  nineMap.put('8', "tuv"); nineMap.put('9', "wxyz");
        
        List<String> res = new LinkedList<>();
        int l = digits.length();
        if (l == 0) {
            return res;
        }
        int[] cnt = new int[l], pos = new int[l];
        for (int i = 0; i < l; i++) {
            cnt[i] = nineMap.get(digits.charAt(i)).length();
        }
        while (pos[0] < cnt[0]) {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < l; i++) {
                ans.append(nineMap.get(digits.charAt(i)).charAt(pos[i]));
            }
            pos[l - 1]++;
            for (int k = l - 1; k > 0; k--) {
                pos[k - 1] += (pos[k] / cnt[k]);
                pos[k] = pos[k] % cnt[k];
            }
            res.add(ans.toString());
        }
        return res;
    }
}