import utils.ListNode;

public class middle19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            pre = pre.next;
            fast = fast.next;
        }

        pre.next = pre.next.next;

        return dummy.next;
    }
}
