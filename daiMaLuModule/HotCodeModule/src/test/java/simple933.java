import java.util.Deque;
import java.util.LinkedList;

public class simple933 {
    class RecentCounter {

        private Deque<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList();
        }

        public int ping(int t) {
            queue.offer(t);
            while (!queue.isEmpty() && t - 3000 > queue.peek()) {
                queue.poll();
            }
            return queue.size();
        }
    }
}
