import utils.ListNode;

public class middle148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middlePrev = getMiddle(head);
        ListNode middle = middlePrev.next;
        middlePrev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(middle);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode curA = left;
        ListNode curB = right;

        while (curA != null && curB != null) {
            if (curA.val < curB.val) {
                cur.next = curA;
                curA = curA.next;
            } else {
                cur.next = curB;
                curB = curB.next;
            }
            cur = cur.next;
        }

        while (curA != null) {
            cur.next = curA;
            curA = curA.next;
            cur = cur.next;
        }

        while (curB != null) {
            cur.next = curB;
            curB = curB.next;
            cur = cur.next;
        }

        return dummy.next;
    }


    private ListNode getMiddle(ListNode node) {
        ListNode pre = null;
        ListNode slow = node;
        ListNode fast = node;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return pre;
    }
}
