public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        };
        int row = matrix.length, col = matrix[0].length;
        int up = 0, left = 0, down = row - 1, right = col - 1;
        while(up < down) {
            int mid = up + (down - up) / 2;
            if(matrix[mid][col-1] < target) {  
                up = mid + 1;
            } 
            else {
                down = mid;
            }
        }
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(matrix[up][mid] < target) { 
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return matrix[up][left] == target;
    }
}