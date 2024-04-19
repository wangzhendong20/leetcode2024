import utils.ListNode;

public class middle148 {
    /**
     * 148. 排序链表
     * 归并排序
     * 找中点，分成左右两个链表，递归排序，合并两个有序链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle = findMiddle(head);
        ListNode RHead = middle.next;
        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(RHead);

        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        while (left != null) {
            cur.next = left;
            left = left.next;
            cur = cur.next;
        }

        while (right != null) {
            cur.next = right;
            right = right.next;
            cur = cur.next;
        }

        return dummy.next;

    }


    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev;
    }
}
