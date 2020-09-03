import java.util.HashSet;
import java.util.Set;

public class Leetcode52 {
    private int size;
    int res;
    private Set<Integer> columns, diagonals1, diagonals2;

    public int totalNQueens(int n) {
        size = n;
        res = 0;
        columns = new HashSet<>();  diagonals1 = new HashSet<>();  diagonals2 = new HashSet<>();
        backtrack(0);
        return res;
    }

    public void backtrack(int row) {
        if (row == size) {
            res++;
        } 
        else {
            for (int i = 0; i < size; i++) {
                int digIdx1 = row - i, digIdx2 = row + i;
                if (!columns.contains(i) && !diagonals1.contains(digIdx1) && !diagonals2.contains(digIdx2)) {
                    columns.add(i);  diagonals1.add(digIdx1); diagonals2.add(digIdx2);
                    backtrack(row + 1);
                    columns.remove(i);  diagonals1.remove(digIdx1);  diagonals2.remove(digIdx2);
                }
            }
        }
    }
}
