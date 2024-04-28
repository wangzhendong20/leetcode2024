package lc395th;

import java.util.Arrays;

public class code100285 {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return -(nums1[0] - nums2[0]);
    }
}
