import java.util.HashMap;

public class middle560 {
    /**
     * 前缀和+哈希表
     * 说实话没太懂
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int pre = 0;
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre,0)+1);
        }
        return ans;
    }
}
