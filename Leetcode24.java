public class Leetcode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head.next, second = head;
        second.next = swapPairs(first.next);
        first.next = second; 
        return first;
    }
}