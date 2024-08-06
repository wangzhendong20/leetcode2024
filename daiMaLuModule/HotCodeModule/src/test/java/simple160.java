import utils.ListNode;

public class simple160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lenA = 0, lenB = 0;

        ListNode nodeA = headA, nodeB = headB;

        while (nodeA != null) {
            lenA++;
            nodeA = nodeA.next;
        }
        while(nodeB != null) {
            lenB++;
            nodeB = nodeB.next;
        }

        if (lenA < lenB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }

        int diff = Math.abs(lenA - lenB);

        nodeA = headA;
        nodeB = headB;

        while (diff-- > 0 && nodeA != null) {
            nodeA = nodeA.next;
        }

        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return null;

    }
}
