import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Leetcode5512 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        List<HashMap<Integer, Integer>> friends = new LinkedList<>();
        for (int[] pre : preferences) {
            HashMap<Integer, Integer> frd = new HashMap<>();
            for (int i = 0; i < pre.length; i++) {
                frd.put(pre[i], i);
            }
            friends.add(frd);
        }
        int ans = 0;
        for (int[] cp : pairs) {
            int c1 = cp[0], c2 = cp[1];
            for (int[] chk : pairs) {
                int k1 = chk[0], k2= chk[1];
                if (k1 == c1 && k2 == c2) {
                    continue;
                }
                if (friends.get(c1).get(k1) <  friends.get(c1).get(c2) && friends.get(k1).get(c1) < friends.get(k1).get(k2)) {
                    ans++;
                    break;
                }
                else if (friends.get(c1).get(k2) <  friends.get(c1).get(c2) && friends.get(k2).get(c1) < friends.get(k2).get(k1)) {
                    ans++;
                    break;
                }
            }
            for (int[] chk : pairs) {
                int k1 = chk[0], k2= chk[1];
                if (k1 == c1 && k2 == c2) {
                    continue;
                }
                if (friends.get(c2).get(k1) <  friends.get(c2).get(c1) && friends.get(k1).get(c2) < friends.get(k1).get(k2)) {
                    ans++;
                    break;
                }
                else if (friends.get(c2).get(k2) <  friends.get(c2).get(c1) && friends.get(k2).get(c2) < friends.get(k2).get(k1)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
