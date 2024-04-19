import utils.ListNode;

public class simple141 {
    /**
     * 141. 环形链表
     * https://leetcode-cn.com/problems/linked-list-cycle/
     * 快慢指针法
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
