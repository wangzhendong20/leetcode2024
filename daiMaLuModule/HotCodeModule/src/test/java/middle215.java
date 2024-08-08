import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class middle215 {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numsList = new ArrayList<Integer>();
        for (int num : nums) {
            numsList.add(num);
        }
        return quickSelect(numsList, k);
    }

    private int quickSelect(List<Integer> nums, int k) {
        Random random = new Random();
        int pivot = nums.get(random.nextInt(nums.size()));

        List<Integer> small = new ArrayList<Integer>();
        List<Integer> equal = new ArrayList<Integer>();
        List<Integer> large = new ArrayList<Integer>();

        for (Integer num : nums) {
            if (num == pivot) {
                equal.add(num);
            } else if (num < pivot) {
                small.add(num);
            } else {
                large.add(num);
            }
        }

        if (k <= large.size()) {
            return quickSelect(large, k);
        } else if (nums.size() - small.size() < k) {
            return quickSelect(small, k - nums.size() + small.size());
        } else {
            return pivot;
        }

    }
}
