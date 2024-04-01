package middle;

import utils.ListNode;

public class middle61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode a = head;
        int len = 0;
        while (a != null) {
            len++;
            a = a.next;
        }
        if (k % len == 0) return head;
        ListNode cur = head;
        ListNode fast = head;
        for (int i = 0; i < len - (k % len) - 1; i++) {
            fast = fast.next;
        }
        ListNode nextCur = fast.next;
        fast.next = null;
        ListNode newNode = nextCur;
        ListNode curNode = newNode;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = cur;
        return newNode;
    }
}
