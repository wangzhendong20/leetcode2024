import java.util.HashMap;
import java.util.HashSet;

public class simple1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num),i};
            }
            map.put(nums[i],i);
        }

        return result;
    }
}
