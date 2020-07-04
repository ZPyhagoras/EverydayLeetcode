import java.util.Stack;

public class Leetcode32 {
    public int longestValidParentheses(String s) {
        return stackSolution(s);
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
}