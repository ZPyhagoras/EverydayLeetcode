import java.util.HashMap;
import java.util.Map;

public class Leetcode10 {
    public boolean isMatch(String s, String p) {
        Map<Integer, Map<Character, Integer[]>> DFA = new HashMap<>();
        char[] S = s.toCharArray(), P = p.toCharArray();
        int ns = S.length, np = P.length;
        int curState = 0, order = 0;
        for (int i = 0; i < np; i++) {
            char ch = P[i];
            char nch = i + 1 < np ? P[i + 1] : '#';
            i = nch == '*' ? i + 1 : i;

            Map<Character, Integer[]> states = DFA.getOrDefault(curState, new HashMap<>());
            int nextState = nch == '*' ? curState : curState + 1;
            order = curState == nextState ? order + 1 : 0;
            if (states.keySet().contains(ch) && states.get(ch)[0] == curState) {
                continue;
            }
            states.put(ch, new Integer[]{nextState, order});
            DFA.put(curState, states);
            curState = nextState;
        }
        int lastState = curState, preState = -1, preOrder = -1, curOrder = 0;
        curState = 0;
        for (int i = 0; i < ns; i++) {
            char ch = S[i];
            Map<Character, Integer[]> states = DFA.getOrDefault(curState, new HashMap<>());
            preState = curState;  preOrder = curOrder;
            if (states.keySet().contains(ch)) {
                curState = states.get(ch)[0];
                curOrder = states.get(ch)[1];
            }
            else if (states.keySet().contains('.')) {
                curState = states.get('.')[0];
                curOrder = states.get('.')[1];
            }
            else {
                return false;
            }
            if (preState == curState) {
                if (curOrder < preOrder) {
                    return false;
                }
            }
        }
        return curState == lastState;
    }
}
