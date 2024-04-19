import utils.ListNode;

import java.util.Arrays;

public class hard23 {
    /**
     * 23. 合并K个排序链表
     * 归并排序
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        if (len == 1) return lists[0];

        int mid = len / 2;
        ListNode left = mergeKLists(Arrays.copyOfRange(lists, 0, mid));
        ListNode right = mergeKLists(Arrays.copyOfRange(lists, mid, len));

        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (left != null && right!= null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (left != null) tail.next = left;
        if (right != null) tail.next = right;

        return dummy.next;
    }

}
