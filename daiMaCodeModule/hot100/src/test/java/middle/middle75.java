package middle;

public class middle75 {
    /**
     * 遇到0就排在左边，遇到1就排到右边
     * 剩下的中间都是1
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; ) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
                left++;
                i++;
            } else if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[right];
                nums[right] = tmp;
                right--;
            } else {
                i++;
            }
        }

        for (int i = left; i <= right; i++) {
            nums[i] = 1;
        }
    }
}
