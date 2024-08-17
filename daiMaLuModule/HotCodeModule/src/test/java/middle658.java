import java.util.*;

public class middle658 {
    /**
     * heap
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k,(a,b) -> b[1]-a[1]);

        for (int i = 0; i < arr.length; i++) {
            if (pq.size() >= k) {
                if (Math.abs(arr[i] - x) < Math.abs(pq.peek()[1])) {
                    pq.poll();
                    pq.offer(new int[]{arr[i], Math.abs(arr[i] - x)});
                }
            } else {
                pq.offer(new int[]{arr[i], Math.abs(arr[i] - x)});
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()[0]);
        }
        Collections.sort(res);

        return res;
    }

    /**
     * 双指针删除元素
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        List<Integer> res = new ArrayList<>();
        int removeNum = arr.length - k;
        while (removeNum-- > 0) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                right--;
            } else {
                left++;
            }
        }
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    /**
     * 二分查找边界
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements3(int[] arr, int k, int x) {
        int size = arr.length;
        int left = 0;
        int right = size - k;
        while (left < right) {
             int mid = left + (right - left) / 2;
            // 尝试从长度为 k + 1 的连续子区间删除一个元素
            // 从而定位左区间端点的边界值
            if (x - arr[mid] > arr[mid + k] - x) {
                // 下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间是 [left..mid]
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
