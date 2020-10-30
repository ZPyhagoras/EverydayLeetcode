import java.util.List;

import Datastructure.ListNode;

public class Leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while (head != null) {
            ListNode tail = pre;
            int cnt = 0;
            while (cnt < k && tail != null) {
                tail = tail.next;
                cnt++;
            }
            if (tail == null) {
                return dummyHead.next;
            }
            ListNode nex = tail.next;
            ListNode[] reverse = reverseNodes(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return dummyHead.next;
    }

    private ListNode[] reverseNodes(ListNode head, ListNode tail) {
        ListNode end = tail.next, p = head;
        while (end != tail) {
            ListNode nxt = p.next;
            p.next = end;
            end = p;
            p = nxt;
        }
        return new ListNode[]{tail, head};
    }
}