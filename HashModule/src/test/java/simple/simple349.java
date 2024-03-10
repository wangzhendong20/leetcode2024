package simple;

import java.util.ArrayList;

public class simple349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hash = new int[1001];
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            hash[num] = 1;
        }

        for (int num : nums2) {
            if (hash[num] == 1) {
                list.add(num);
                hash[num] = 0;
            }
        }


        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
