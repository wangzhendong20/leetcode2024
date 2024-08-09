public class middle75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                nums[left] = nums[index];
                left++;
                index++;
            } else if (nums[index] == 2) {
                int temp = nums[right];
                nums[right] = nums[index];
                nums[index] = temp;
                right--;
            } else {
                index++;
            }
        }

        for (int i = left; i <= right; i++) {
            nums[i] = 1;
        }

    }
}
