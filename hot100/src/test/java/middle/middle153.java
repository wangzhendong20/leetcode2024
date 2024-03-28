package middle;

public class middle153 {
    /**
     * 找到mid左侧有序的一侧，那么min就是最left的那个，然后让left = mid + 1找mid无序的那侧
     * 如果mid右侧有序就减小空间，right = mid - 1;
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < min) {
                min = nums[mid];
            } else if (nums[mid] >= nums[left]) {
                //左边有序
                min = Math.min(min,nums[left]);
                left = mid + 1;
            } else {
                //右侧有序就减小空间
                right = mid - 1;
            }

        }
        return min;
    }
}
