public class Leetcode214 {
    public String shortestPalindrome(String s) {
        char[] sChars = s.toCharArray();
        int len = s.length(), maxLen = len;
        int i = 0, j = len - 1;
        while (i <= j) {
            if (sChars[i] == sChars[j]) {
                i++;
                j--;
            }
            else {
                i = 0;
                maxLen--;
                j = maxLen;
            }
        }
        System.out.println(maxLen);
        String add = (maxLen >= len - 1 ? "" : s.substring(maxLen + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }
}