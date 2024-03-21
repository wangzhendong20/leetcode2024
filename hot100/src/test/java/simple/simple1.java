package simple;

import java.util.HashMap;

public class simple1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp) && map.get(tmp) != i) {
                return new int[]{i,map.get(tmp)};
            }
        }

        return new int[]{};
    }
}
