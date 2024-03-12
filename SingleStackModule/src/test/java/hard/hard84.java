package hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class hard84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights,0,newHeight,1,heights.length);
        newHeight[0] = 0;
        newHeight[heights.length+1] = 0;

        stack.push(0);
        for (int i = 1; i < newHeight.length; i++) {
            if (newHeight[i] > newHeight[stack.peek()]) {
                stack.push(i);
            } else if (newHeight[i] == newHeight[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int h = newHeight[mid];
                        int w = i - stack.peek() - 1;
                        res = Math.max(res,h*w);
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }
}
