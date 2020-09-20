package LCPwithKY;

public class LCP01 {
    public static int paintingPlan(int n, int k) {
        int cnt = n * n - k;
        int ans = 0;
        if (cnt == 0) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            if (cnt % i == 0 && cnt / i <= n) {
                int j = cnt / i;
                int col = combination(j, n);
                int row = combination(i, n);
                ans += col * row;
            }
        }
        return ans;
    }
    
    public static int factorial(int n) {
        int sum = 1;
        while (n >= 1) {
            sum = sum * n;
            n--;
        }
        return sum;
    }

    public static int combination(int m, int n) {
        return m <= n ? factorial(n) / (factorial(n - m) * factorial(m)) : 0;
    }

    public static void main(String[] args) {
        System.out.println(paintingPlan(2, 4));
    }
}
