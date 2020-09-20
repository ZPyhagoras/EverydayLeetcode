package LCPwithKY;

public class LCP04 {
    private static final long mod = 1000000007;
    public int keyboard(int k, int n) {
        long ans = 0;
        if (n > k) {
            ans = factorial(26) * factorial(n / k - 1) % mod / factorial(26 - n / k) % mod;
        }
        else {
            ans = 26 * factorial(n) % mod;
        }
        return (int)(ans % mod);
    }

    public long factorial(int n) {
        long sum = 1;
        long N = (long)n;
        while (N >= 1) {
            sum = sum * N % mod;
            N--;
        }
        return sum % mod;
    }
}
