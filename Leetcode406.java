import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Leetcode406 {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> hghCmp = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                else {
                    return o2[0] - o1[0];
                }
            }
        };
        Arrays.sort(people, hghCmp);
        List<int[]> ans = new LinkedList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
