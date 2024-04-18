package hard;

import java.util.Deque;
import java.util.LinkedList;

public class hard239 {

    class MyQueue {
        //单调队列
        Deque<Integer> deque = new LinkedList<>();

        // 每次弹出的时候，比较当前要弹出的数值是否等于队列出口元素的数值，如果相等则弹出。
        // 同时pop之前判断队列当前是否为空。
        void pop(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.pop();
            }
        }

        // 如果push的数值大于入口元素的数值，那么就将队列后端的数值弹出，直到push的数值小于等于队列入口元素的数值为止。
        // 这样就保持了队列里的数值是单调从大到小的了。
        //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
        void push(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
        }

        int peek() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue = new MyQueue();

        int len = nums.length - k + 1;
        int[] ans = new int[len];
        int num = 0;

        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        ans[num++] = queue.peek();

        for (int i = k; i < nums.length; i++) {
            queue.pop(nums[i-k]);

            queue.push(nums[i]);

            ans[num++] = queue.peek();
        }
        return ans;
    }
}
