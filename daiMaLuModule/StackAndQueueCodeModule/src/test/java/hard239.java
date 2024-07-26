import java.util.Deque;
import java.util.LinkedList;

public class hard239 {

    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        void push(int val) {
            while(!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        int peek() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue = new MyQueue();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        res[index++] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i-k]);
            queue.push(nums[i]);
            res[index++] = queue.peek();
        }
        return res;
    }
}
