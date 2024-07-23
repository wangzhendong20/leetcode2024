import java.util.Deque;
import java.util.LinkedList;

public class hard84 {
    /**
     * 单调栈：找到下一个小的数
     * 找到下一个小的数，然后计算面积
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        int[] newHeights = new int[heights.length + 2];  //保证两边的都可以被计算
        System.arraycopy(heights,0,newHeights,1,heights.length);
        newHeights[0] = 0;
        newHeights[newHeights.length-1] = 0;
        stack.push(0);

        for (int i = 1; i < newHeights.length; i++) {
            if (newHeights[i] > newHeights[stack.peek()]) {  //如果当前高度大于栈顶高度的话，就入栈
                stack.push(i);
            } else if (newHeights[i] == newHeights[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else { //当前高度小于栈顶高度，开始计算面积
                while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                    int mid = stack.pop();  //中间的高度
                    if (!stack.isEmpty()) {
                        int h = newHeights[mid];  //高度
                        int w = i - stack.peek() - 1;  //宽度
                        res = Math.max(res, h*w);
                    }
                }
                stack.push(i);
            }
        }

        return res;
    }
}
