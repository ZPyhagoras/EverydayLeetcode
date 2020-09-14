package Week204;

import java.util.ArrayList;
import java.util.List;

public class Q4 {
    private static final int mod = (int)(1e9 + 7);
    public int numOfWays(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(nums[i]);
        }
        return f(list) - 1;
    }

    public int f(List<Integer> list){
        if(list.isEmpty())  { 
            return 1;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int n = list.size();
        int flag = list.get(0);
        for(int i = 1; i < n; i++){
            if(list.get(i) < flag) {
                left.add(list.get(i));
            }
            else {
                right.add(list.get(i));
            }
        }
        int less = f(left) % mod, more = f(right) % mod;
        return (int)((long)combination(n - 1, left.size()) * less * more % mod);
    }

    private int combination(int m,int n){
        if(n == 0) {
            return 1;
        }
        if (n == 1) {
            return m % mod;
        }
        if(n > m / 2) {
            return combination(m, m - n) % mod;
        }
        if(n > 1) {
            return (combination(m - 1, n - 1) + combination(m - 1, n)) % mod;  
        }
        return -1;
    }
}