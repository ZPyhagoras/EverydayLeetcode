import java.util.LinkedList;
import java.util.List;

public class Leetcode22 {
    private List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new LinkedList<>();
        generate(n, n, "");
        return res;
    }

    private void generate(int l, int r, String brackets) {
        if (l == 0 && r == 0) {
            res.add(brackets);
        }
        else {
            if (l > 0) {
                generate(l - 1, r, brackets + "(");
            }
            if (l < r) {
                generate(l, r - 1, brackets + ")");
            }
        }
    }
}