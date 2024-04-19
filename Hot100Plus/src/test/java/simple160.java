import utils.ListNode;

public class simple160 {
    /**
     * 160. Intersection of Two Linked Lists
     * https://leetcode.com/problems/intersection-of-two-linked-lists/
     * 计算链表长度的差值
     * 让一个链表节点先走这个差值，之后进行比较，直到找到相同的节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        int lenB = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA!= null) {
            lenA++;
            pA = pA.next;
        }
        while (pB!= null) {
            lenB++;
            pB = pB.next;
        }

        if (lenA < lenB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }

        int diff = Math.abs(lenA - lenB);
        ListNode curA = headA;
        ListNode curB = headB;

        while (diff > 0) {
            curA = curA.next;
            diff--;
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
