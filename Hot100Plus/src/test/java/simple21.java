import utils.ListNode;

public class simple21 {
    /**
     * 21. Merge Two Sorted Lists
     * 创建一个dummy节点
     * 之后比较两个链表节点，小的就放到新链表里
     * 剩下的部分直接接到新链表的后面
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode cur1 = list1, cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                curr.next = cur1;
                cur1 = cur1.next;
            } else {
                curr.next = cur2;
                cur2 = cur2.next;
            }
            curr = curr.next;
        }

        if (cur1 != null) curr.next = cur1;
        if (cur2 != null) curr.next = cur2;


        return dummy.next;
    }
}
