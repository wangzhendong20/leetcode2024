package middle;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class middle503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for (int i = 0; i < n * 2; i++) {  //模拟循环两边数组
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                ans[stack.peek()] = nums[i % n];
                stack.pop();
            }
            stack.push(i % n);
        }

        return ans;
    }
}
