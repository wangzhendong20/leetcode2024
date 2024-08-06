import utils.ListNode;

public class hard25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy;

        while (curr.next != null) {
            for (int i = 0; i < k && curr != null; i++) {
                curr = curr.next;
            }
            if (curr == null) break;

            ListNode nextStart = curr.next;
            curr.next = null;
            ListNode start = prev.next;

            ListNode newStart = reverse(start);

            prev.next = newStart;
            start.next = nextStart;

            prev = start;
            curr = start;

        }

        return dummy.next;

    }


    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

}
