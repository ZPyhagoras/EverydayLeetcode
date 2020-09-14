import java.util.ArrayList;
import java.util.List;

public class Leetcode679 {
    private static final double eps = 1e-6;
    public boolean judgePoint24(int[] nums) {
        List<Double> numList = new ArrayList<>();
        for (int v: nums)  {
            numList.add((double) v);
        }
        return solve(numList);
    }

    private boolean solve(List<Double> numList) {
        if (numList.size() == 1)  {
            return Math.abs(numList.get(0) - 24) < eps;
        }

        for (int i = 0; i < numList.size(); i++) {
            for (int j = 0; j < numList.size(); j++) {
                if (i == j) {
                    continue;
                }
                List<Double> tmp = new ArrayList<>();
                for (int k = 0; k < numList.size(); k++) {
                    if (k != i && k != j) {
                        tmp.add(numList.get(k));
                    }
                }
                
                tmp.add(numList.get(i) + numList.get(j));
                if (solve(tmp)) {
                    return true;
                }
                tmp.remove(tmp.size() - 1);

                tmp.add(numList.get(i) * numList.get(j));
                if (solve(tmp)) {
                    return true;
                }
                tmp.remove(tmp.size() - 1);

                tmp.add(numList.get(i) - numList.get(j));
                if (solve(tmp)) {
                    return true;
                }
                tmp.remove(tmp.size() - 1);

                if (numList.get(j) > eps) {
                    tmp.add(numList.get(i) / numList.get(j));
                    if (solve(tmp)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
    