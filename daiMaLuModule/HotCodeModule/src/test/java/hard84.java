import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class hard84 {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights,0, newHeights, 1, heights.length);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int maxArea = 0;

        for (int i = 1; i < newHeights.length; i++) {
            if (newHeights[i] > newHeights[stack.peek()]) {
                stack.push(i);
            } else if (newHeights[i] == newHeights[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int h = newHeights[mid];
                        int w = i - stack.peek() - 1;
                        int area = h * w;
                        maxArea = Math.max(maxArea, area);
                    }
                }
                stack.push(i);
            }
        }
        return maxArea;
    }
}
