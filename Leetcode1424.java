import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> transform = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                transform.getOrDefault(i + j, new ArrayList<>());
            }
        }
        int[] ans = 
        for (List<Integer> row : transform) {
            for (Integer n : row) {

            }
        }
    }
}