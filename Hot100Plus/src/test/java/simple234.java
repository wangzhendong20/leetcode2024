import utils.ListNode;

public class simple234 {
    /**
     * 234. 回文链表
     * 模板题
     * https://leetcode-cn.com/problems/palindrome-linked-list/
     * 找中点，反转后半段链表，再比较前后两段链表是否相同
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        ListNode reversedNode = reverseList(slow);

        ListNode cur = head;
        ListNode reversedCur = reversedNode;
        while (cur != null && reversedCur != null) {
            if (cur.val != reversedCur.val) {
                return false;
            }
            cur = cur.next;
            reversedCur = reversedCur.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }
}
