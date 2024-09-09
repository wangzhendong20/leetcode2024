package tuyou;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class code3 {

    static PriorityQueue<Integer> minPq = new PriorityQueue<>();
    static PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);

    private static void balance() {
        if (maxPq.size() > minPq.size() + 1) {
            minPq.offer(maxPq.poll());
        } else if (minPq.size() > maxPq.size()) {
            maxPq.offer(minPq.poll());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int k = in.nextInt();

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            for (int i = 0; i < n; i++) {
                if (maxPq.isEmpty() || nums[i] <= maxPq.peek()) {
                    maxPq.offer(nums[i]);
                } else {
                    minPq.offer(nums[i]);
                }
                balance();
                if (i >= k) {
                    if (nums[i-k] <= maxPq.peek()) {
                        maxPq.remove(nums[i-k]);
                    } else {
                        minPq.remove(nums[i-k]);
                    }
                    balance();
                }

                if (i >= k - 1) {
                    double num = getMid();
                    if (num == (int) num) {
                        System.out.print((int)num + " ");
                    } else {
                        System.out.print(String.format("%.1f", num) + " ");
                    }
                }

            }

        }

    }

    private static double getMid() {

        if (maxPq.size() > minPq.size()) {
            return maxPq.peek();
        }

        return (maxPq.peek() + minPq.peek()) / 2.0;

    }
}
