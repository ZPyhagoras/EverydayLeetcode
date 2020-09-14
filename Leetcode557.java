public class Leetcode557 {
    public String reverseWords(String s) {
        String[] subStrings = s.split(" ");
        StringBuffer ans = new StringBuffer(new StringBuffer(subStrings[0]).reverse().toString());
        for (int i = 1; i < subStrings.length; i++) {
            ans.append(' ');
            ans.append(new StringBuffer(subStrings[i]).reverse().toString());
        }
        return ans.toString();
    }
}