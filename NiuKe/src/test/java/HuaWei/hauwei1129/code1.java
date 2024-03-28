package HuaWei.hauwei1129;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            int ans = getNum(nums,n);
            System.out.println(ans);
        }
    }

    /**
     * 用队列来模拟
     * 遇到-1的时候就出队列，不是-1时将元素插入到顺序的位置
     * @param nums
     * @param n
     * @return
     */
    private static int getNum(int[] nums, int n) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.offer(i);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == -1) {
                deque.poll();
            } else {
                if (deque.peek() < nums[i]) {
                    insertNum(deque,nums[i]);
                } else {
                    deque.offerFirst(nums[i]);
                }
            }
        }

        return deque.peek();
    }

    /**
     * 插入到相应的位置
     * @param deque
     * @param num
     */
    private static void insertNum(Deque<Integer> deque, int num) {
        Deque<Integer> stack = new LinkedList<>();
        while (deque.peek() < num) {
            stack.push(deque.poll());
        }

        deque.offer(num);
        while (!stack.isEmpty()) {
            deque.offerFirst(stack.pop());
        }
    }
}
