import java.util.Stack;

public class Leetcode20 {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> cp = new Stack<>();
        char[] sChars = s.toCharArray();
        for (char ch : sChars) {
            if (ch == '(' || ch == '[' || ch == '{') {
                cp.push(ch);
            }
            else if (ch == ')') {
                 if (cp.peek() == '(') {
                     cp.pop();
                 }
                 else {
                     return false;
                 }
            }
            else if (ch == ']') {
                if (cp.peek() == '[') {
                    cp.pop();
                }
                else {
                    return false;
                }
           }
           else if (ch == '}') {
                if (cp.peek() == '{') {
                    cp.pop();
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}