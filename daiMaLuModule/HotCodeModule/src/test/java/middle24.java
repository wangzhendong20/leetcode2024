import utils.ListNode;

public class middle24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dummy;
        pre.next = cur;

        while (cur != null && cur.next != null) {
            ListNode nextNode = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = nextNode;
            pre = cur;
            cur = nextNode;
        }

        return dummy.next;
    }
}
