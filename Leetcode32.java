import java.util.Stack;

public class Leetcode32 {
    public int longestValidParentheses(String s) {
        return (stackSolution(s) == twiceTraverseSolution(s)) ? stackSolution(s) : -1;
    }

    private int stackSolution(String s) {
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                indexStack.push(i);
            }
            else {
                indexStack.pop();
                if (indexStack.empty()) {
                    indexStack.push(i);
                }
                else {
                    ans = Math.max(ans, i - indexStack.peek());
                }
            }
        }
        return ans;
    }

    private int twiceTraverseSolution(String s) {
        int left, right, ans;
        ans = left = right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            }
            else {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, left + right);
            }
            else if (left < right) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            }
            else {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, left + right);
            }
            else if (right < left) {
                left = right = 0;
            }
        }
        return ans;
    }
}