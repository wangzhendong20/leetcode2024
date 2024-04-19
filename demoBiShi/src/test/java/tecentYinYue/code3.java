package tecentYinYue;

public class code3 {
    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static int getMethod (ListNode head, String colors) {
        if (head == null) {
            return 0;
        }
        int RJ = 0;
        int RO = 0;
        int allJ = 0;
        int allO = 0;
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            if (cur.val % 2 == 0) {
                allO++;
                if (colors.charAt(index) == 'R') {
                    RO++;
                }
            } else {
                allJ++;
                if (colors.charAt(index) == 'R') {
                    RJ++;
                }
            }
            index++;
            cur = cur.next;
        }

        long sum = 0;
        long diffO = allO - RO;
//        long numO = 1L;
//        while  (diffO > 0) {
//            sum += numO * 2;
//            numO *= 2;
//            diffO--;
//        }
        long sumO = (long) Math.pow(2,diffO);
        long num = 1L;
        if (RJ % 2 == 0) {
            long diffJ = allJ - RJ;
            if (diffJ > 0) {
                if (diffJ % 2 == 0) {
//                while (diffJ > 0) {
//                    num *= 2;
//                    diffJ--;
//                }
//                num += 1;
                    num += (long) Math.pow(2,diffJ-1);
                } else {
//                while (diffJ > 0) {
//                    num *= 2;
//                    diffJ--;
//                }
                    num += (long) Math.pow(2,diffJ-1);
//                num -= 1;
                }
            }
        } else {
            long rawDiffJ = allJ - RJ;
            long diffJ = allJ - RJ - 1;
            if (rawDiffJ > 0) {
                num *= rawDiffJ;
            }
            if (diffJ > 0) {
                if (diffJ % 2 == 0) {
//                    diffJ--;
//                    while (diffJ > 0) {
//                        num *= 2;
//                        diffJ--;
//                    }
//                    num += 1;
                    num += (long) Math.pow(2,diffJ-1);
                }else {
//                    diffJ--;
//                    while (diffJ > 0) {
//                        num *= 2;
//                        diffJ--;
//                    }
                    num += (long) Math.pow(2,diffJ-1);
//                num -= 1;
                }
            }
        }

        sum += sumO * num;


        return (int) (sum % (1000000007));
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        String colors = "RWW";
        System.out.println(getMethod(head,colors));
    }
}
