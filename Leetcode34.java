public class Leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        left = left < nums.length && nums[left] == target ? left : -1;
        right = right >= 0 && nums[right] == target ? right : -1;
        return new int[]{left, right};
    }
    
    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int low, high, mid;
        low = 0;  high = nums.length - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < target || (nums[mid] == target && !isLeft)) {
                low = mid + 1;
            }
            else if (nums[mid] > target || (nums[mid] == target && isLeft)) {
                high = mid - 1;
            }
        }
        return isLeft ? low : high;
    }
}
