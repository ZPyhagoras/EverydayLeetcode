import java.util.HashMap;
import java.util.Map;

public class Leetcode5508 {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> square1 = new HashMap<>();
        Map<Long, Integer> square2 = new HashMap<>();
        for (int n : nums1) {
            long sqr = (long) n * (long)n;
            square1.put(sqr, square1.getOrDefault(sqr, 0) + 1);
        }
        for (int n : nums2) {
            long sqr = (long) n * (long)n;
            square2.put(sqr, square2.getOrDefault(sqr, 0) + 1);
        }
        int sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                long sqr = (long)nums1[i] * (long)nums1[j];
                sum += square2.getOrDefault(sqr, 0);
            }
        }
        System.out.println(2);
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                long sqr = (long)nums2[i] * (long)nums2[j];
                sum += square1.getOrDefault(sqr, 0);
            }
        }
        return sum;
    }
}
