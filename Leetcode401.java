import java.util.LinkedList;
import java.util.List;

public class Leetcode401 {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (bitCount(i) + bitCount(j) == num) {
                    ans.add(Integer.toString(i) + ":" + (j < 10 ? "0" : "") + Integer.toString(j));
                }
            }
        }
        return ans;
    }

    public static int bitCount(int n){
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0F0F0F0F) + ((n >>> 4) & 0x0F0F0F0F);
        n = (n & 0x00FF00FF) + ((n >>> 8) & 0x00FF00FF);
        n = (n & 0x0000FFFF) + ((n >>> 16) & 0x0000FFFF);
        return n;
    }
}