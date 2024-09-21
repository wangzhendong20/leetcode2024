package vivo;

import java.util.Deque;
import java.util.LinkedList;

public class code2 {
    class maxQueue {
        Deque<Integer> deque = new LinkedList<>();
        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        void add(int val) {
            while(!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        int peek(){
            return deque.peek();
        }
    }

    class minQueue {
        Deque<Integer> deque = new LinkedList<>();
        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        void add(int val) {
            while(!deque.isEmpty() && val < deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        int peek(){
            return deque.peek();
        }
    }

    public int[] findFluctuations (int[] memoryUsage, int k) {
        int n = memoryUsage.length;
        if (n == 1) {
            return memoryUsage;
        }

        int len = n - k + 1;
        int[] res = new int[len];
        maxQueue maxQ = new maxQueue();
        minQueue minQ = new minQueue();

        for (int i = 0; i < k; i++) {
            maxQ.add(memoryUsage[i]);
            minQ.add(memoryUsage[i]);
        }
        int index = 0;
        res[index++] = maxQ.peek() - minQ.peek();
        for (int i = k; i < memoryUsage.length; i++) {
            maxQ.poll(memoryUsage[i-k]);
            minQ.poll(memoryUsage[i-k]);
            maxQ.add(memoryUsage[i]);
            minQ.add(memoryUsage[i]);
            res[index++] = maxQ.peek() - minQ.peek();
        }

        return res;

    }
}
