import java.util.Deque;
import java.util.LinkedList;

public class hard42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        if (height.length == 0) return res;
        stack.push(0);

        for (int i = 0; i < height.length; i++) {
            if (height[stack.peek()] > height[i]) {
                stack.push(i);
            } else if (height[stack.peek()] == height[i]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int h = Math.min(height[i], height[stack.peek()]) - height[mid];
                        int w = i - stack.peek() - 1;
                        int area = h * w;
                        res += area;
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }
}
