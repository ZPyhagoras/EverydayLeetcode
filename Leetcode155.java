import java.util.LinkedList;
import java.util.List;

public class Leetcode155 {
    private List<Integer> MainStack;
    private List<Integer> MinNums;

    /** initialize your data structure here. */
    public Leetcode155() {
        MainStack = new LinkedList<>();
        MinNums = new LinkedList<>();
        MinNums.add(0, Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        MainStack.add(0, x);
        int cur_min = Math.min(x, MinNums.get(0));
        MinNums.add(0, cur_min);
    }
    
    public void pop() {
        MainStack.remove(0);
        MinNums.remove(0);
    }
    
    public int top() {
        return MainStack.get(0);
    }
    
    public int getMin() {
        return MinNums.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
