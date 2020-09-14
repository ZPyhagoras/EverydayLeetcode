package LCP;

public class LCP02 {
    public int[] fraction(int[] cont) {
        int n = cont.length;
        int[] ans = {cont[n - 1], 1};
        for (int i = n - 2; i >= 0; i--) {
            ans[0] = ans[1];  ans[1] = ans[0];
            ans[0] = ans[0] + ans[1] * cont[i];
        }
        return ans;
    }
}
