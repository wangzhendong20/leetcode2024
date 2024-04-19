import utils.ListNode;

public class middle24 {
    /**
     * 24. 两两交换链表中的节点
     * 主要逻辑：
     * while (cur != null && cur.next != null) {
     *     utils.ListNode tmp1 = cur.next;
     *     utils.ListNode tmp2 = cur.next.next;
     *     pre.next = tmp1;
     *     tmp1.next = cur;
     *     cur.next = tmp2;
     *
     *     pre = cur;
     *     cur = tmp2;
     * }
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode tmp1 = cur.next;
            ListNode tmp2 = cur.next.next;
            pre.next = tmp1;
            tmp1.next = cur;
            cur.next = tmp2;

            pre = cur;
            cur = tmp2;
        }

        return dummy.next;
    }
}
