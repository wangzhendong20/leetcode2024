package simple;

import utils.ListNode;

public class simple160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }

        if (lenA < lenB) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }

        curA = headA;
        curB = headB;
        int k = Math.abs(lenA - lenB);
        while (k > 0) {
            curA = curA.next;
            k--;
        }

        while (curA != null) {
            if (curA == curB) return curA;
            else {
                curA = curA.next;
                curB = curB.next;
            }
        }

        return null;
    }
}
