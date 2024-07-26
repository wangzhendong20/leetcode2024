public class middle707 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            this.val=val;
        }
    }

    class MyLinkedList {

        int size;
        ListNode head;

        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            ListNode cur = head.next;
            while (index-- > 0 && cur != null) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) return;
            if (index < 0) index = 0;
            ListNode newNode = new ListNode(val);
            ListNode prev = head;
            while (index-- > 0) {
                prev = prev.next;
            }

            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
             if (index < 0 || index >= size) return;
             ListNode prev = head;
             if (index == 0) {
                 head = head.next;
             }

             while (index-- > 0) {
                 prev = prev.next;
             }

             prev.next = prev.next.next;
             size--;
        }
    }
}
