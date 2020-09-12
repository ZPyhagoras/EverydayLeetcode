package PersonalContest;

import java.util.Arrays;

public class Q3 {
    public int cost(char a, char b) {
        return a == b ? 0 : 1;
    }

    public int minimumOperations(String leaves) {
        int[] last = new int[4];
        int[] next = new int[4];
        Arrays.fill(last, Integer.MAX_VALUE);
        last[0] = 0;
        for (char c : leaves.toCharArray()) {
            Arrays.fill(next, Integer.MAX_VALUE);
            next[1] = Math.min(last[1] + cost('r', c), cost('r', c));
            next[2] = Math.min(last[2] + cost('y', c), last[1] + cost('y', c));
            next[3] = Math.min(last[3] + cost('r', c), last[2] + cost('r', c));
            int[] tmp = last;
            last = next;
            next = tmp;
        }
        return last[3];
    }

    public static void main(String[] args) {
        System.out.println(minimumOperations("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrry"));
    }
}
