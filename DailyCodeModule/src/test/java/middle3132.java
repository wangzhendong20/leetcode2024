import java.util.Arrays;

public class middle3132 {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 2; i > 0; i--) {
            int x = nums2[0] - nums1[i];

            int j = 0;
            for (int k = i; k < nums1.length; k++) {
                if (nums2[j] == nums1[k] + x && j++ == nums2.length - 1) {
                    return x;
                }
            }
        }

        return nums2[0] - nums1[0];
    }
}
