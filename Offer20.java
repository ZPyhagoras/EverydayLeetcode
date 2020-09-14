import java.util.HashSet;
import java.util.Set;

public class Offer20 {
    public boolean isNumber(String s) {
        Set<Integer> acceptSet = new HashSet<>();
        acceptSet.add(3);  acceptSet.add(5);
        acceptSet.add(8);  acceptSet.add(9);
        int state = 1;
        for (char ch : s.toCharArray()) {
            if (state == 1) {
                if (ch == ' ') {
                    state = 1;
                }
                else if (ch >= '0' && ch <= '9') {
                    state = 3;
                }
                else if (ch == '+' || ch == '-') {
                    state = 2;
                }
                else if (ch == '.') {
                    state = 4;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 2) {
                if (ch >= '0' && ch <= '9') {
                    state = 3;
                }
                else if (ch == '.') {
                    state = 4;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 3) {
                if (ch >= '0' && ch <= '9') {
                    state = 3;
                }
                else if (ch == '.') {
                    state = 5;
                }
                else if (ch == 'e' || ch == 'E') {
                    state = 6;
                }
                else if (ch == ' ') {
                    state = 9;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 4) {
                if (ch >= '0' && ch <= '9') {
                    state = 5;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 5) {
                if (ch >= '0' && ch <= '9') {
                    state = 5;
                }
                else if (ch == 'e' || ch == 'E') {
                    state = 6;
                }
                else if (ch == ' ') {
                    state = 9;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 6) {
                if (ch >= '0' && ch <= '9') {
                    state = 9;
                }
                else if (ch == '+' || ch == '-') {
                    state = 7;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 7) {
                if (ch >= '0' && ch <= '9') {
                    state = 8;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 8) {
                if (ch >= '0' && ch <= '9') {
                    state = 8;
                }
                else if (ch == ' ') {
                    state = 9;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 9) {
                if (ch == ' ') {
                    state = 9;
                }
                else {
                    state = -1;
                    break;
                }
            }
        }
        return acceptSet.contains(state);
    }
}