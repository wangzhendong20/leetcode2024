import utils.ListNode;

public class middle82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        boolean flag = false;
        while (cur != null) {

            if (cur.next == null) {
                // 到了最后一个节点，如果flag为true，说明有重复的节点，直接删除
                if (flag) {
                    pre.next = null;
                }
                break;
            }
            // 非末尾节点，判断是否有重复
            if (cur.val == cur.next.val) {
                // 有重复, cur继续往后走，flag置为true
                flag = true;
                cur = cur.next;
            } else {
                // 遇到不重复的节点，判断flag是否为true，如果为true，则删除重复节点，刷新flag
                if (flag) {
                    pre.next = cur.next;
                    cur = cur.next;
                    flag = false;
                } else {
                    // 否则继续后移
                    pre = cur;
                    cur = cur.next;
                }
            }
        }

        return dummy.next;
    }
}
