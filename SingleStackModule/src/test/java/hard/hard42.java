package hard;

import java.util.Deque;
import java.util.LinkedList;

public class hard42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[stack.peek()]) { //情况一
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) { //情况二
                stack.pop();
                stack.push(i);
            } else { //情况三
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int h = Math.min(height[i],height[stack.peek()]) - height[mid];
                        int w = i - stack.peek() - 1;
                        sum += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
}
