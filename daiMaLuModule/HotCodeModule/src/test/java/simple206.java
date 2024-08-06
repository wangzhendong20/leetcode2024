import utils.ListNode;

public class simple206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;

        ListNode cur = head;

        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }

        return pre;

    }
}
