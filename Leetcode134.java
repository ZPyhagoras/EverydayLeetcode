public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minNum = 0, remain = 0;
        int ans = -1;
        for (int i = 0; i < gas.length; i++) {
            remain += (gas[i] - cost[i]);
            if (remain < minNum) {
                minNum = remain;
                ans = i;
            }
        }
        return remain < 0 ? -1 : ans + 1; 
    }
}
