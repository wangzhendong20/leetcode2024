import utils.ListNode;

public class simple21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;


        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode curA = list1;
        ListNode curB = list2;

        while (curA!= null && curB!= null) {
            if (curA.val < curB.val) {
                curr.next = curA;
                curA = curA.next;
            } else {
                curr.next = curB;
                curB = curB.next;
            }
            curr = curr.next;
        }

        while (curA != null) {
            curr.next = curA;
            curA = curA.next;
            curr = curr.next;
        }
        while (curB != null) {
            curr.next = curB;
            curB = curB.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}
