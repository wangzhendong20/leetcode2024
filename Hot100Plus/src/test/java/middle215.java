import java.util.*;

public class middle215 {
    /**
     * 基于快速选择算法的第 k 大元素查找
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        return quickSelect(numsList, k);
    }

    private int quickSelect(List<Integer> nums, int k) {
        Random random = new Random();
        int pivot = nums.get(random.nextInt(nums.size()));

        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot) {
                small.add(num);
            } else if (num > pivot) {
                big.add(num);
            } else {
                equal.add(num);
            }
        }

        if (k <= big.size()) { //第 k 大元素在 big 中
            return quickSelect(big,k);
        } else if (nums.size() - small.size() < k) { //第 k 大元素在 small 中
            return quickSelect(small, k - nums.size() + small.size());
        } else {
            return pivot;
        }

    }
}
