package middle;

import java.util.HashMap;

public class middle454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i]+nums2[j];
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                ans += map.getOrDefault(-num3 - num4,0);
            }
        }
        return ans;
    }
}
