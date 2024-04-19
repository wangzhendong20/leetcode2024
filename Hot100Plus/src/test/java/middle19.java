import utils.ListNode;

public class middle19 {
    /**
     * 19. 删除链表的倒数第N个节点
     * 创建一个dummy节点，之后用一个pre.next指向head
     * 然后让fast走n步
     * 然后让prev和fast同时走，当fast到达末尾的时候，prev指向倒数第n个节点的前一个节点
     * 然后prev.next指向prev.next.next，删除倒数第n个节点
     * 返回dummy.next
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            prev = prev.next;
            fast = fast.next;
        }

        prev.next = prev.next.next;
        return dummy.next;
    }
}
