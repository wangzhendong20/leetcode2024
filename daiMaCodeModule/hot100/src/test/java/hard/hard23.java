package hard;

import utils.ListNode;

import java.util.Arrays;
import java.util.List;

public class hard23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeK(lists);
    }

    private ListNode mergeK(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 当列表只剩下一个数组或为空时，直接返回
        if (lists.length == 1) {
            return lists[0];
        }

        // 递归地将数组列表分为两部分并合并
        int mid = lists.length / 2;
        ListNode[] left = Arrays.copyOfRange(lists,0,mid);
        ListNode[] right = Arrays.copyOfRange(lists,mid,lists.length);

        ListNode leftMerged = mergeK(left);
        ListNode rightMerged = mergeK(right);

        // 合并两个已排序的数组
        return mergeTwoLists(leftMerged, rightMerged);
    }


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
}
