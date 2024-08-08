public class middle153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] >= nums[left]) {
                //左边有序
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return min;
    }
}
