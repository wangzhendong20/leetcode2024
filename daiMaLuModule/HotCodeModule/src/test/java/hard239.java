import java.util.Deque;
import java.util.LinkedList;

public class hard239 {
    class MyQueue {
        Deque<Integer> deque;

        public MyQueue() {
            deque = new LinkedList<>();
        }

        public void add(int val) {
            while (!deque.isEmpty() && deque.getLast() < val) {
                deque.removeLast();
            }
            deque.add(val);
        }

        public void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        public int peek() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        MyQueue queue = new MyQueue();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int index = 0;

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        ans[index++] = queue.peek();

        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i - k]);
            queue.add(nums[i]);
            ans[index++] = queue.peek();
        }

        return ans;
    }
}
