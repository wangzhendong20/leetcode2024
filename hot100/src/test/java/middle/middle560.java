package middle;

import java.util.Arrays;
import java.util.HashMap;

public class middle560 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
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
