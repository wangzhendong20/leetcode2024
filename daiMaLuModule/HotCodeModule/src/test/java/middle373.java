import java.util.*;

public class middle373 {
    /**
     * 最小的k对数只能是nums1[0]或nums2[0]中选一个，然后再从其它的里面选择小的。
     * 所以可以用小根堆来存。
     * 要注意去重。
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{nums1[i] + nums2[0], i , 0});
        }

        while (res.size() < k) {
            int[] cur = pq.poll();
            int i = cur[1];
            int j = cur[2];
            res.add(List.of(nums1[i], nums2[j]));
            if (j + 1 < nums2.length) {
                // 防止重复出现
                pq.offer(new int[]{nums1[i] + nums2[j+1], i, j+1});
            }

        }

        return res;
    }
}
