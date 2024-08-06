import utils.ListNode;

import java.util.Arrays;

public class hard23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        int mid = lists.length / 2;

        ListNode left = mergeKLists(Arrays.copyOfRange(lists,0, mid));
        ListNode right = mergeKLists(Arrays.copyOfRange(lists,mid, lists.length));

        return mergeTowLists(left,right);
    }

    private ListNode mergeTowLists(ListNode left, ListNode right) {

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
}
