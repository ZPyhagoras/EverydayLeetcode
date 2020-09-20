import Datastructure.ListNode;

public class Leetcode148 {
    public ListNode sortList1(ListNode head) {
        return head == null ? null : mergeSort(head, null);
    }

    private ListNode mergeSort(ListNode front,ListNode rear){
        if(front == rear) {
            return front;
        }
        ListNode low = front, high = front;
        while(high != rear) { 
            high = high.next;
            if(high != rear){
                high = high.next;
                low = low.next;
            }
        }
        ListNode lowNext = low.next;
        low.next = null;
        return mergeTwoList(mergeSort(front,low), mergeSort(lowNext,rear));
    }

    private ListNode mergeTwoList(ListNode front,ListNode rear){
        ListNode node = new ListNode(0) , r = node;
        while(front != null && rear != null){
            if(front.val < rear.val){
                node.next = front;
                front = front.next;
            }
            else{
                node.next = rear;
                rear = rear.next;
            }
            node = node.next;
        }
        if(front != null) 
            node.next = front;
        if(rear != null)
            node.next = rear;
        return r.next;
    }

    public ListNode sortList(ListNode head) {
        int n = 0;
        for(ListNode i = head; i != null; i = i.next) {
            n++;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        for (int i = 1; i < n; i <<= 1) {
            ListNode begin = dummy;
            for (int j = 0; j + i < n; j = j + (i << 1)) {
                ListNode first = begin.next, second = first;
                for(int k = 0; k < i; k++) {
                    second = second.next;
                }

                int f = 0, s = 0;
                while (f < i && s < i && second != null){
                    if (first.val < second.val){
                        begin.next = first;
                        first = first.next;
                        f++;
                    }
                    else{
                        begin.next = second;
                        second = second.next;
                        s++;
                    }
                    begin = begin.next;
                }

                while (f < i){
                    begin.next = first;
                    begin = begin.next;
                    first = first.next;
                    f++;
                }
                while (s < i && second != null){
                    begin.next = second;
                    begin = begin.next;
                    second = second.next;
                    s++;
                }
                begin.next = second;
            }
        }
        return dummy.next;
    }
}
