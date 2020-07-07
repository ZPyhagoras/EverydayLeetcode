public class Leetcode1491 {
    public double average(int[] salary) {
        int mins = Integer.MAX_VALUE, maxs = Integer.MIN_VALUE;
        double sum = 0;
        for (int sal : salary) {
            mins = sal < mins ? sal : mins;
            maxs = sal > maxs ? sal : maxs;
            sum += sal;
        }
        return sum / (salary.length - 2);
    }
}