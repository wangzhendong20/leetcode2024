import java.util.Deque;
import java.util.LinkedList;

public class hard42 {
    /**
     * 单调栈   单调栈里存的是下标
     * 找到两边第一大的柱子
     * 按行来计算雨水量
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Deque<Integer> deque = new LinkedList<>();
        int sum = 0;
        deque.push(0);

        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[deque.peek()]) {
                deque.push(i);
            } else if (height[i] == height[deque.peek()]) {
                deque.pop();
                deque.push(i);
            } else {
                while (!deque.isEmpty() && height[i] > height[deque.peek()]) {
                    int mid = deque.pop();
                    if (!deque.isEmpty()) {
                        int left = deque.peek();
                        int curHeight = Math.min(height[left],height[i]) - height[mid];
                        int curLen = i - left - 1;
                        sum += curHeight * curLen;
                    }
                }
                deque.push(i);
            }
        }
        return sum;
    }
}
