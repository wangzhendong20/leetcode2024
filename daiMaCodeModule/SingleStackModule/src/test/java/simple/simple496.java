package simple;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class simple496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[nums1.length];
        Arrays.fill(ans,-1);
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        stack.push(0);

        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    if (map.containsKey(nums2[stack.peek()])){
                        Integer index = map.get(nums2[stack.peek()]);
                        ans[index] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return ans;
    }
}
