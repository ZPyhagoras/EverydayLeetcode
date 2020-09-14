import java.util.Arrays;

public class Leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);  Arrays.sort(nums2);
        int l1 = nums1.length, l2 = nums2.length;
        int[] ans = new int[Math.min(l1, l2)];
        int idx, idx1, idx2;
        idx = idx1 = idx2 = 0;
        while (idx1 < l1 && idx2 < l2) {
            if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            }
            else if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            }
            else {
                ans[idx] = nums1[idx1];
                idx++; idx1++; idx2++;
            }
        }
        return Arrays.copyOfRange(ans, 0, idx);
    }
}