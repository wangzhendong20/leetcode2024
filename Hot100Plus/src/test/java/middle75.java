public class middle75 {
    /**
     * 三种颜色, 0,1,2排序，让0在左面，2在右面，中间就全是1
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                nums[left] = nums[i];
                left++;
                i++;
            } else if (nums[i] == 2) {
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
            } else if (nums[i] == 1) {
                i++;
            }
        }

        for (int j = left; j <= right; j++) {
            nums[j] = 1;
        }

    }
}
