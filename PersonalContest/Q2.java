package PersonalContest;

import java.util.Arrays;

public class Q2 {
    private static final long mod = 1000000007;
    public int breakfastNumber1(int[] staple, int[] drinks, int x) {
        long ans = 0;
        int[] count = new int[x + 1];
        for (int s : staple) {
            if (s < x) {
                count[s]++;
            }
        }
        for (int i = 2; i < x; i++) {
            count[i] += count[i - 1];
        }
        for (int d : drinks) {
            int tmp = x - d;
            if (tmp > 0) {
                ans = (ans + count[tmp]) % mod;
            }
        }
        return (int)(ans % mod);
    }

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        long ans = 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int m = staple.length, n = drinks.length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (staple[i] + drinks[j] <= x) {
                ans = (ans + (long)j + 1) % mod;
                i++;
            }
            else {
                j--;
            }
        }
        return (int)(ans % mod);
    }
}
