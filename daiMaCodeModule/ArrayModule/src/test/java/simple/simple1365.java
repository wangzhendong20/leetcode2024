package simple;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class simple1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] originNums = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(nums);

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                map.put(nums[i], i);
            }
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < originNums.length; i++) {
            res[i] = map.get(originNums[i]);
        }

        return res;
    }
}
