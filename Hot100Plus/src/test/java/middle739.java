import java.util.Deque;
import java.util.LinkedList;

public class middle739 {
    /**
     * 单调栈：里面存的是下标
     * ->求下一个大的元素
     * 单调栈是递增的，当进栈元素大于栈顶元素时，栈顶元素出栈
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];

        stack.push(0);

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) { // 遇到比栈顶元素大的元素
                result[stack.peek()] = i - stack.peek();  // 记录下标差值就是下一个大的元素
                stack.pop();
            }
            stack.push(i);
        }

        return result;
    }
}
