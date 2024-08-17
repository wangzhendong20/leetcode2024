import utils.ListNode;

public class middle92 {
    /**
     * 找到切割位置，断链，然后反转，再连接起来
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        for (int i = 1; i < left && cur != null; i++) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = null;
        ListNode leftEnd = pre;
        ListNode reversedStart = cur;

        for (int i = left; i < right && cur != null; i++) {
            cur = cur.next;
        }
        ListNode rightStart = cur.next;
        cur.next = null;

        ListNode reversed = reverse(reversedStart);

        leftEnd.next = reversed;
        reversedStart.next = rightStart;

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }

        return pre;
    }
}
