package middle;

public class middle33 {
    /**
     * 从mid中分开一定是一侧有序，另一侧可能有序
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                //左边有序
                if (nums[mid] > target && target >= nums[left]) {
                    //target在left和mid之间
                    right = mid - 1;
                } else {
                    //target不在left和mid之间
                    left = mid + 1;
                }
            } else {
                //右边有序
                if (nums[mid] < target && target <= nums[right]) {
                    //target在mid和right之间
                    left = mid + 1;
                } else {
                    //target不在mid和right之间
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
