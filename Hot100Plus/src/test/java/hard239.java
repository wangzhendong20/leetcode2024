import java.util.Deque;
import java.util.LinkedList;

public class hard239 {
    /**
     * 单调队列
     * 每次只保存可能得最大值
     * 所以遇到比当前值大的数就将当前值出队列，大值进队列
     * 否则，比当前值小的数直接进队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        MyQueue queue = new MyQueue();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        res[index++] = queue.peek();

        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i-k]);
            queue.add(nums[i]);
            res[index++] = queue.peek();
        }

        return res;
    }

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
}
