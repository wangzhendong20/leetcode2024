package meiTuan0409;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class code1 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {

        ListNode cur = head;
        ListNode midNode = midNode(head);
        ListNode NextNode = midNode.next;
        midNode.next = null;
        ListNode left = sortList(cur);
        ListNode right = sortList(NextNode);

        return mergeList(left,right);
    }

    private ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * 合并两个有序链表
     * @return
     */
    private ListNode mergeList(ListNode left, ListNode right) {
        return null;
    }

}



