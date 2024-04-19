import utils.ListNode;

public class hard25 {
    /**
     * 25.K 个一组翻转链表
     * 首先本题会用到翻转链表的模板题
     * 首先我们创建一个dummy节点，将要翻转链表的头结点和尾节点都指向dummy节点
     * 之后计算长度是否满足k，如果不满足就break，如果满足就进行翻转
     * 先将k个节点的尾节点与下一部分的头节点断开，然后翻转这k个节点
     * 然后将翻转后的链表的头节点和尾节点连接到原链表的前一个节点和后一个节点
     * 之后pre和end都指向翻转后的链表的尾节点，继续翻转下一个k个节点翻转
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;

            ListNode nextStart = end.next;
            end.next = null;

            ListNode start = prev.next;
            ListNode newStart = reverseList(start);

            prev.next = newStart;
            start.next = nextStart;

            prev = start;
            end = start;

        }


        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr!= null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
