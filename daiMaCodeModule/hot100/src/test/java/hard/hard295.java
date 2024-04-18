package hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class hard295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }

}

class MedianFinder {
    /**
     * 大顶堆存中间值的左面
     * 小顶堆存中间值的右面
     */
    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;
    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
    }
    public void addNum(int num) {
        if (maxQueue.isEmpty()) {
            maxQueue.add(num);
            return;
        }

        if (num > maxQueue.peek()) {
            minQueue.add(num);
        } else {
            maxQueue.add(num);
        }
        while (maxQueue.size() - minQueue.size() > 1) {
            minQueue.add(maxQueue.poll());
        }

        while (minQueue.size() - maxQueue.size() > 1) {
            maxQueue.add(minQueue.poll());
        }

    }
    public double findMedian() {
        if (minQueue.size() == maxQueue.size()) {
            return  (double) (minQueue.peek() + maxQueue.peek()) / 2;
        } else {
            return maxQueue.size() > minQueue.size() ? (double) maxQueue.peek() : (double) minQueue.peek();
        }
    }
}
