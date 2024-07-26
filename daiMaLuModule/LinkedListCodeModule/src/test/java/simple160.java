public class simple160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;

        while (curA != null) {
            lenA++;
            curA = curA.next;
        }

        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        int diff = Math.abs(lenA - lenB);
        if (lenB > lenA) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }

        curA = headA;
        curB = headB;

        while (diff-- > 0) {
            curA = curA.next;
        }

        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }
}
