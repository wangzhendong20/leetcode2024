import utils.ListNode;

public class middle142 {
    /**
     * 142. 环形链表 II
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode p1 = head;
                ListNode p2 = slow;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }

        return null;
    }
}
