package xiapi;

import java.util.PriorityQueue;

public class code3 {
    public int maxK(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else {
                if (num > pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;

    }
}
