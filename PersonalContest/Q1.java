package PersonalContest;

public class Q1 {
    public int calculate(String s) {
        int x = 1, y = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'A') {
                x = 2 * x + y;
            }
            else if (ch == 'B') {
                y = 2 * y + x;
            }
        }
        return x + y;
    }
}
