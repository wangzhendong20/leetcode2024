package middle;

import utils.ListNode;

public class middle143 {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;

        ListNode cur1 = head;
        ListNode cur2 = reverseList(slow);
        ListNode preCur2 = null;
        ListNode tmp1 = null;
        ListNode tmp2 = null;
        while (cur1 != null) {
            preCur2 = cur2;
            tmp1 = cur1.next;
            tmp2 = cur2.next;
            cur1.next = cur2;
            cur2.next = tmp1;
            cur1 = tmp1;
            cur2 = tmp2;
        }

        preCur2.next = tmp2;
    }

    private ListNode reverseList(ListNode head) {
        ListNode tmp;
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
