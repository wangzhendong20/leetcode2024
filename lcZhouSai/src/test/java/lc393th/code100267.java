package lc393th;

import java.util.Arrays;
import java.util.PriorityQueue;

public class code100267 {

    public static void main(String[] args) {
        int[] coins = {3,6,9};
        int k = 3;
        System.out.println(findKthSmallest(coins, k));
    }

    public static int findKthSmallest(int[] coins, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        for (int i = 1; i <= k; i++) {
            pq.poll();
            long current = i;
            for (int coin : coins) {
                if (!pq.contains(current * coin)) {
                    pq.offer(current * coin);
                }
            }
        }
        return (int) (long) pq.poll();
    }

}
