package middle;

import utils.ListNode;

public class middle2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        boolean diff = false;
        while (cur1 != null && cur2 != null) {
            if (diff == false) {
                if (cur1.val+cur2.val >= 10) {
                    ListNode node = new ListNode((cur1.val + cur2.val)%10);
                    cur.next = node;
                    diff = true;
                } else {
                    ListNode node = new ListNode(cur1.val+cur2.val);
                    cur.next = node;
                    diff = false;
                }
            } else {
                if (cur1.val+cur2.val + 1 >= 10) {
                    ListNode node = new ListNode((cur1.val + cur2.val + 1)%10);
                    cur.next = node;
                    diff = true;
                } else {
                    ListNode node = new ListNode(cur1.val+cur2.val + 1);
                    cur.next = node;
                    diff = false;
                }
            }

            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null) {
            if (diff){
                if (cur1.val + 1 >= 10) {
                    ListNode node = new ListNode((cur1.val+1)%10);
                    cur.next = node;
                    diff = true;
                } else {
                    ListNode node = new ListNode(cur1.val+1);
                    cur.next = node;
                    diff = false;
                }
            } else {
                cur.next = cur1;
                diff = false;
            }
            cur = cur.next;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            if (diff){
                if (cur2.val + 1 >= 10) {
                    ListNode node = new ListNode((cur2.val+1)%10);
                    cur.next = node;
                    diff = true;
                } else {
                    ListNode node = new ListNode(cur2.val+1);
                    cur.next = node;
                    diff = false;
                }
            } else {
                cur.next = cur2;
                diff = false;
            }
            cur = cur.next;
            cur2 = cur2.next;
        }
        if (diff) {
            ListNode node = new ListNode(1);
            cur.next = node;
        }

        return dummy.next;
    }

}
