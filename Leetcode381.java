import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode381 {
    
}

class RandomizedCollection {
    Map<Integer, Set<Integer>> numsHash;
    List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        numsHash = new HashMap<>();
        nums = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> indexSet = numsHash.getOrDefault(val, new HashSet<>());
        nums.add(val);
        indexSet.add(nums.size() - 1);
        numsHash.put(val, indexSet);
        return indexSet.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!numsHash.containsKey(val)) {
            return false;
        }
        Iterator<Integer> it = numsHash.get(val).iterator();  
        int idx = it.next();
        int lastNum = nums.get(nums.size() - 1);
        nums.set(idx, lastNum);
        numsHash.get(val).remove(idx);
        numsHash.get(lastNum).remove(nums.size() - 1);
        if (idx < nums.size() - 1) {
            numsHash.get(lastNum).add(idx);
        }
        if (numsHash.get(val).size() == 0) {
            numsHash.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int)(Math.random() * nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */