import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsCnt = new HashMap<>();
        PriorityQueue<int[]> kFrequent = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] A, int[] B) {
                return A[1] - B[1];
            }
        });
        for (int n : nums) {
            numsCnt.put(n, numsCnt.getOrDefault(n, 0) + 1);
        }
        for (int key : numsCnt.keySet()) {
            int[] pair = new int[]{key, numsCnt.get(key)};
            kFrequent.offer(pair);
            if (kFrequent.size() > k) {
                kFrequent.poll();
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while (!kFrequent.isEmpty()) {
            ans[i] = kFrequent.poll()[0];
            i++;
        }
        return ans;
    }
}
