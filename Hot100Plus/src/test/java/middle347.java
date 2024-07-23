import java.util.*;

public class middle347 {
    /**
     * 最小堆，O(nlogk)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(new int[]{entry.getKey(),entry.getValue()});
            } else {
                if (entry.getValue() > priorityQueue.peek()[1]) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }

        int[] ans = new int[k];
        for (int i = k-1; i >= 0; i--) {
            ans[i] = priorityQueue.poll()[0];
        }

        return ans;
    }

    /**
     * 桶排序（计数排序），O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        // 构建一个桶，每个桶存放对应频率的元素
        List<Integer>[] bucket = new List[nums.length+1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(entry.getKey());
        }

        int[] ans = new int[k];
        int index = 0;
        for (int i = bucket.length-1; i >= 0 && k > 0; i--) {
            if (bucket[i] == null) continue;
            for (Integer integer : bucket[i]) {
                ans[index++] = integer;
                k--;
            }
        }

        return ans;
    }
}
