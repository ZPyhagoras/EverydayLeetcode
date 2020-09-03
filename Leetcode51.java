import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode51 {
    private int size;
    private int[] queens;
    private List<List<String>> res;
    private Set<Integer> columns, diagonals1, diagonals2;

    public List<List<String>> solveNQueens(int n) {
        size = n;
        res = new ArrayList<List<String>>();
        columns = new HashSet<>();  diagonals1 = new HashSet<>();  diagonals2 = new HashSet<>();
        queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(0);
        return res;
    }

    public void backtrack(int row) {
        if (row == size) {
            res.add(generateBoard(queens, size));
        } 
        else {
            for (int i = 0; i < size; i++) {
                int digIdx1 = row - i, digIdx2 = row + i;
                if (!columns.contains(i) && !diagonals1.contains(digIdx1) && !diagonals2.contains(digIdx2)) {
                    queens[row] = i;
                    columns.add(i);  diagonals1.add(digIdx1); diagonals2.add(digIdx2);
                    backtrack(row + 1);
                    columns.remove(i);  diagonals1.remove(digIdx1);  diagonals2.remove(digIdx2);
                }
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
