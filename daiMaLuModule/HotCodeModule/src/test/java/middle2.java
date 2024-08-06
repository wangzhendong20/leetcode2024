import utils.ListNode;

public class middle2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        boolean flag = false;

        while (cur1 != null && cur2 != null) {
            int tmp = cur1.val + cur2.val;
            if (flag) {
                tmp++;
                flag = false;
            }

            if (tmp < 10) {
                ListNode newNode = new ListNode(tmp);
                cur.next = newNode;
                cur = cur.next;
            } else {
                flag = true;
                ListNode newNode = new ListNode(tmp % 10);
                cur.next = newNode;
                cur = cur.next;
            }

            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null) {
            int tmp = cur1.val;
            if (flag) {
                tmp++;
                flag = false;
            }
            if (tmp < 10) {
                ListNode newNode = new ListNode(tmp);
                cur.next = newNode;
                cur = cur.next;
            } else {
                flag = true;
                ListNode newNode = new ListNode(tmp % 10);
                cur.next = newNode;
                cur = cur.next;
            }
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            int tmp = cur2.val;
            if (flag) {
                tmp++;
                flag = false;
            }
            if (tmp < 10) {
                ListNode newNode = new ListNode(tmp);
                cur.next = newNode;
                cur = cur.next;
            } else {
                flag = true;
                ListNode newNode = new ListNode(tmp % 10);
                cur.next = newNode;
                cur = cur.next;
            }
            cur2 = cur2.next;
        }

        if (flag) {
            ListNode newNode = new ListNode(1);
            cur.next = newNode;
        }

        return dummy.next;
    }
}
