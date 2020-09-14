import Datastructure.ListNode;

public class Leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode headNode = new ListNode(Integer.MIN_VALUE);
        ListNode p = headNode;
        int n = lists.length;
        while (true) {
            int minn = Integer.MAX_VALUE, row = -1;
            for (int i = 0; i < n; i++) {
                if (lists[i] != null && lists[i].val < minn) {
                    minn = lists[i].val;
                    row = i;
                }
            }
            if (row >= 0) {
                lists[row] = lists[row].next;
                ListNode q = new ListNode(minn);
                p.next = q;
                p = q;
            }
            else {
                break;
            }

        }
        return headNode.next;
    }
}