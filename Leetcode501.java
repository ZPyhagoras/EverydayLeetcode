import java.util.ArrayList;
import java.util.List;

import Datastructure.TreeNode;

public class Leetcode501 {
    int preVal = 0, curTimes = 0, maxTimes = 0;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        traversal(root);
        int size = list.size();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void traversal(TreeNode root){
        if(root != null){
            traversal(root.left);
            if(preVal == root.val){
                curTimes++;
            }
            else{
                preVal = root.val;
                curTimes = 1;
            }
            if(curTimes == maxTimes){
                list.add(root.val);
            }
            else if(curTimes > maxTimes){
                list.clear();
                list.add(root.val);
                maxTimes = curTimes;
            }
            traversal(root.right);
        }
    }
}
