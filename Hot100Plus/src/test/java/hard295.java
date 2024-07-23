import java.util.PriorityQueue;

public class hard295 {
    class MedianFinder {
        //左面大顶堆
        PriorityQueue<Integer> minHeap;
        //右面小顶堆
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            maxHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (minHeap.isEmpty()) {
                minHeap.add(num);
                return;
            }

            if (num > minHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            if (maxHeap.size() - minHeap.size() > 0) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) * 0.5;
            } else {
                return (double) minHeap.peek();
            }
        }
    }
}
