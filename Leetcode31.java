public class Leetcode31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int fstMinus = n - 2;
        while (fstMinus >= 0 && nums[fstMinus] >= nums[fstMinus + 1]) {
            fstMinus--;
        }
        fstMinus = Math.max(0, fstMinus);
        int bigger = n - 1;
        while (bigger >= 0 && nums[fstMinus] >= nums[bigger]) {
            bigger--;
        }
        swap(nums, fstMinus, bigger);
        reverse(nums, fstMinus + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
