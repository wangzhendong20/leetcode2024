package middle;

import java.util.Deque;
import java.util.LinkedList;

public class middle739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                if (temperatures[i] > temperatures[stack.peek()]) {
                    ans[stack.peek()] = i - stack.peek();
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
