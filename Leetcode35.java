public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            }
            else if (nums[mid] < target) {
                l = mid + 1;
            }
            else {
                return mid;
            }
        }
        return l;
    }
}