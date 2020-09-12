import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        long[] primeNums = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Long, List<String>> strsMap = new HashMap<>();
        for (String str : strs) {
            long sum = 1;
            for (char ch : str.toCharArray()) {
                sum *= primeNums[ch - 'a'];
            }
            List<String> tmp = strsMap.getOrDefault(sum, new ArrayList<>());
            tmp.add(str);
            strsMap.put(sum, tmp);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Long, List<String>> s : strsMap.entrySet()) {
            res.add(s.getValue());
        }
    
        return res;
    }
}
