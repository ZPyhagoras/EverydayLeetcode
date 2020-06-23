public class Leetcode67 {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int la = a.length(), lb = b.length(), l = Math.max(la, lb);

        boolean ta, tb, carry;
        carry = false;
        for (int i = 1; i <= l; i++) {
            ta = i > la ? false : (a.charAt(la - i) == '1');
            tb = i > lb ? false : (b.charAt(lb - i) == '1');
            ans.insert(0, (ta ^ tb ^ carry) ? "1" : "0");
            carry = (ta & tb) | (ta & carry) | (tb & carry);
        }
        if (carry) {
            ans.insert(0, "1");
        }
        return ans.toString();
    }
}