package lc395th;

import java.util.Arrays;

public class code100287 {
    public static int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int min = nums2[0] - nums1[0];
        for (int i = 0; i <= 2; i++) {
            int diff = nums2[0] - nums1[i];
            if (check(nums1,nums2,diff,i)) {
                min = Math.min(min,diff);
            }
        }

        return min;
    }

    private static boolean check(int[] nums1, int[] nums2, int diff, int index) {
        boolean flag1;
        boolean flag2;
        if (index == 1) {
            flag1 = true;
            flag2 = false;
        } else if (index == 2) {
            flag1 = true;
            flag2 = true;
        } else {
            flag1 = false;
            flag2 = false;
        }
        int j = 0;
        for (int i = index; i < nums1.length && j < nums2.length; i++) {
            if (nums1[i] + diff != nums2[j]) {
                if (flag1 && flag2) return false;
                if (flag1) flag2 = true;
                else flag1 = true;
            } else {
                j++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {7,2,6,8,7};
        int[] nums2 = {7,6,5};
        System.out.println(minimumAddedInteger(nums1,nums2));
    }
}
