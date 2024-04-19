import utils.ListNode;

public class middle2 {
    /**
     * 2. Add Two Numbers
     * 相加就行了，使用flag来标记是否需要进位
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        boolean flag = false;

        while (cur1!= null && cur2!= null) {
            int tmp = cur1.val + cur2.val;
            if (flag) {
                tmp += 1;
                flag = false;
            }

            if (tmp < 10) {
                cur.next = new ListNode(tmp);
            } else {
                flag = true;
                cur.next = new ListNode(tmp - 10);
            }
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1!= null) {
            int tmp = cur1.val;
            if (flag) {
                tmp += 1;
                flag = false;
            }

            if (tmp < 10) {
                cur.next = new ListNode(tmp);
            } else {
                flag = true;
                cur.next = new ListNode(tmp - 10);
            }
            cur = cur.next;
            cur1 = cur1.next;
        }

        while (cur2!= null) {
            int tmp = cur2.val;
            if (flag) {
                tmp += 1;
                flag = false;
            }

            if (tmp < 10) {
                cur.next = new ListNode(tmp);
            } else {
                flag = true;
                cur.next = new ListNode(tmp - 10);
            }
            cur = cur.next;
            cur2 = cur2.next;
        }


        if (flag) {
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }
}
