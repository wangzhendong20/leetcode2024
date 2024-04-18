package middle;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class middle148 {
    /**
     * 空间复杂度O(n)
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        Collections.sort(list);
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        for (int i = 0; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            tmp.next = node;
            tmp = tmp.next;
        }

        return dummy.next;
    }


    /**
     * 归并排序
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList2(head);
        ListNode right = sortList2(rightHead);

        return mergeTwoLists(left,right);
    }

    //  合并两个有序链表（21. 合并两个有序链表）
    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val > right.val) {
                cur.next = right;
                right = right.next;
            } else {
                cur.next = left;
                left = left.next;
            }
            cur = cur.next;
        }

        cur.next = left != null ? left : right;

        return dummy.next;
    }

    // 找到链表中间节点（876. 链表的中间结点）
    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
