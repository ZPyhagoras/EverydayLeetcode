package LCPwithKY;

public class LCP02 {
    public boolean isMagic(int[] target) {
        if (target.length == 1) {
            return true;
        }
        int n = target.length;
        if (target[0] != 2) {
            return false;
        }
        int k = 1;
        while (target[k] == target[k - 1] + 2) {
            k++;
        }
        if (k >= n / 2) {
            return true;
        }
        return false;
    }
}
