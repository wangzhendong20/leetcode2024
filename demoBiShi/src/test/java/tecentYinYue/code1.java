package tecentYinYue;

import java.util.Scanner;

public class code1 {
    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode insert0 (ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;

        while (cur != null && cur.next!= null) {
            ListNode node = new ListNode(0);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }
        return head;
    }
}
