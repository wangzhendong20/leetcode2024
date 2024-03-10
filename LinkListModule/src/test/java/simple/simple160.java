package simple;

import utils.ListNode;

public class simple160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0, lenB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null) {
            nodeA = nodeA.next;
            lenA++;
        }
        while (nodeB != null) {
            nodeB = nodeB.next;
            lenB++;
        }

        if (lenA > lenB) {
            ListNode tmp = headB;
            headB = headA;
            headA = tmp;
        }

        int tap = Math.abs(lenA - lenB);

        while (tap > 0 && headB != null) {
            headB = headB.next;
            tap--;
        }

        while (headA != headB) {
            headB = headB.next;
            headA = headA.next;
        }

        return headA;

    }
}
