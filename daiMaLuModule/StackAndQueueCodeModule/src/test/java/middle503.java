import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class middle503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);

        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.peek()] = nums[i % n];
                stack.pop();
            }
            stack.push(i % n);
        }

        return res;
    }
}
