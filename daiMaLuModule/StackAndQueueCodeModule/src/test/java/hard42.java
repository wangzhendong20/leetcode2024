import java.util.Deque;
import java.util.LinkedList;

public class hard42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        stack.push(0);

        for (int i = 0; i < height.length; i++) {
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int w = i - left - 1;
                        int h = Math.min(height[i], height[left]) - height[mid];
                        res += w * h;
                    }
                }
                stack.push(i);
            }
        }

        return res;
    }
}
