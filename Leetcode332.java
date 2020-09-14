import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode332 {
    private Map<String, PriorityQueue<String>> table;
    private List<String> ans;
    public List<String> findItinerary(List<List<String>> tickets) {
        table = new HashMap<>();
        ans = new LinkedList<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            if (!table.containsKey(from)) {
                table.put(from, new PriorityQueue<>());
            }
            table.get(from).add(to);
        }
        dfs("JFK");
        return ans;
    }

    private void dfs(String from) {
        while (table.containsKey(from) && table.get(from).size() > 0) {
            String tmp = table.get(from).poll();
            dfs(tmp);
        }
        ans.add(0, from);
    }
}