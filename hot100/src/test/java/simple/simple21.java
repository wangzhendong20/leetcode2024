package simple;

import utils.ListNode;

public class simple21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode dummy = new ListNode();
        dummy.next = list1;
        ListNode pre = new ListNode();
        pre.next = cur1;

        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                ListNode tmp = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                cur2 = tmp;
                pre = pre.next;
            } else {
                pre = cur1;
                cur1 = cur1.next;
            }
        }

        while (cur2 != null) {
            pre.next = cur2;
            cur2 = cur2.next;
            pre = pre.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(-9);
        list1.next = new ListNode(3);
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(7);
        mergeTwoLists(list1,list2);
    }
}
